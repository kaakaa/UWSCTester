package org.kaakaa.uwsc;

class UWSC {

  static Script script = new Script()
  static AssertUWSC assertUWSC = new AssertUWSC()

  static final String UWSC_EXE = "C:\\Program Files (x86)\\uwsc\\UWSC.exe"

  def static test(closure) {
    UWSC uwsc = new UWSC()
    closure.delegate = uwsc
    closure()
    // 実行すべきスクリプトを一時ファイルに書き出し
    def scriptFile = File.createTempFile("temp",".UWS")
    def logFile = File.createTempFile("Log","log")

    println scriptFile.getAbsolutePath()
    scriptFile.withWriter{ it << getCommands(logFile) }
    //println scriptFile.text

    println scriptFile.exists()
    println scriptFile.setReadable(true, false) && scriptFile.canRead()
    /"${UWSC_EXE}" "${scriptFile.getAbsolutePath()}"/.execute()

    //scriptFile.delete()
    logFile.delete()
  }
  
  void script(closure) {
      closure.delegate = script
      closure( )
  }  
  
  void assertUWSC(closure) {
      closure.delegate = assertUWSC
      closure()
  }
  
  static String getCommands(File logFile){
      def commands = ["Option LogPath='${logFile.getAbsolutePath()}'"]
      commands << script.getCommands()
      commands << "SLEEP(1)"
      commands << assertUWSC.getCommands()
      return commands.join(System.getProperty('line.separator'))
  }
}
