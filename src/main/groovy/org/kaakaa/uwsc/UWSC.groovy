package org.kaakaa.uwsc;

import groovy.util.logging.*
import java.util.logging.*

@Log
class UWSC {

  static final Logger logger = Logger.getLogger(UWSC.class.toString())

  static Script script = new Script()
  static AssertUWSC assertUWSC = new AssertUWSC()

  def static test(closure) {
    logger.info 'start'
    UWSC uwsc = new UWSC()
    closure.delegate = uwsc
    closure()
    // 実行すべきスクリプトを一時ファイルに書き出し
    def scriptFile = File.createTempFile("temp",".UWS")
    def logFile = File.createTempFile("Log",".log")

    log.info("output scriptFile => ${scriptFile.getAbsolutePath()}")
    scriptFile.withWriter{ it << getCommands(logFile) }

    logger.info 'Let execute following UWSC script'
    logger.info scriptFile.text

    Executer.exec(scriptFile)


    final String WINDOWS_ID = logFile.text
    logger.info "Current Active Window ID => ${WINDOWS_ID}"

    logger.info '==== Assert Start ===='
    assert()
    logger.info '==== Assert End ===='

    log.info "delete ${scriptFile.getAbsolutePath()}"
    scriptFile.delete()
    log.info "delete ${logFile.getAbsolutePath()}"
    logFile.delete()
  }

  static void assert(){
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
      def commands = ["Option LOGPATH=\"${logFile.getAbsolutePath()}\""]
      commands << "Option LogFile=2"
      commands << "LOGPRINT(FALSE)"
      commands << script.getCommands()
      commands << "PRINT GETID(GET_ACTIVE_WIN)"
      return commands.join(System.getProperty('line.separator'))
  }
}
