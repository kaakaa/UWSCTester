package org.kaakaa.uwsc;

import groovy.util.logging.*
import java.util.logging.*
import org.kaakaa.uwsc.exec.Executer

@Log
class UWSC {

  static final Logger logger = Logger.getLogger(UWSC.class.toString())

  static Script script = new Script()
  static AssertUWSC assertUWSC = new AssertUWSC()

  static File scriptFile = File.createTempFile("temp",".UWS")
  static File logFile = File.createTempFile("Log",".log")

  def static test(closure) {
    logger.info 'start'
    UWSC uwsc = new UWSC()
    closure.delegate = uwsc
    closure()

    log.info("output scriptFile => ${scriptFile.getAbsolutePath()}")
    scriptFile.withWriter{ it << getCommands(logFile) }

    logger.info 'Let execute following UWSC script'
    logger.info scriptFile.text

    Executer.exec(scriptFile)

    String windowName = logFile.text
    logger.info "Current Active Window Name => ${windowName}"

    logger.info '==== Assert Start ===='
    assertUWSC(windowName, logFile)
    logger.info '==== Assert End ===='

    logger.info "delete ${scriptFile.absolutePath}"
    if(!scriptFile.delete()) { logger.warn "failed to delete scriptFile => ${scriptFile.absolutePath}" }
 
 
    logger.info "delete ${logFile.getAbsolutePath()}"
    if(!logFile.delete()) { logger.warn "failed to delete logFile => ${logFile.absolutePath}" }
  }

  def static void assertUWSC(String windowsID, File logFile){
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

  def static String getCommands(File logFile){
      def commands = ["Option LogPath=\"${logFile.getAbsolutePath()}\""]
      commands << "Option LogFile=2"
      commands << "LOGPRINT(FALSE)"
      commands << script.getCommands()
      commands << "PRINT STATUS(GETID(GET_ACTIVE_WIN),ST_TITLE)"
      return commands.join(System.getProperty('line.separator'))
  }

  

}
