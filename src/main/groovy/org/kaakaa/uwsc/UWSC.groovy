package org.kaakaa.uwsc

import org.kaakaa.uwsc.exec.Executer

class UWSC {

    String name = "Test";
    Script script = new Script()
    AssertUWSC assertUWSC = new AssertUWSC()

    File scriptFile = File.createTempFile("temp",".UWS")
    File logFile = File.createTempFile("Log",".log")

    void test() {
        // run UWSC script
        scriptFile.withWriter{ it << getCommands(logFile) }
        Executer.exec(scriptFile)

        // get acrtive window name for assertion
        String windowName = logFile.text
        assertUWSC(windowName, logFile)

        if(!scriptFile.delete()) println "failed to delete scriptFile => ${scriptFile.absolutePath}"
        if(!logFile.delete()) println "failed to delete logFile => ${logFile.absolutePath}"
    }

    // FIXME change method name
    void assertUWSC(String windowsID, File logFile){
        this.assertUWSC.assertUWSC(windowsID, logFile)
    }

    void script(closure) {
        closure.delegate = script
        closure( )
    }
  
    void assertUWSC(closure) {
        closure.delegate = assertUWSC
        closure()
    }

    String getCommands(File logFile){
        def commands = ["Option LogPath=\"${logFile.getAbsolutePath()}\""]
        commands << "Option LogFile=2"
        commands << "LOGPRINT(FALSE)"
        commands << script.getCommands()
        commands << "PRINT STATUS(GETID(GET_ACTIVE_WIN),ST_TITLE)"
        return commands.join(System.getProperty('line.separator'))
    }
}