package org.kaakaa.uwsc;

class UWSC {

  static Script script = new Script()
  static AssertUWSC assertUWSC = new AssertUWSC()
    
  def static test(closure) {
    UWSC uwsc = new UWSC()
    closure.delegate = uwsc
    closure()
    // 実行すべきスクリプトを一時ファイルに書き出し
    def file = File.createTempFile("temp","uwc")
    println file.toString()
    file.withWriter{ it << getCommands() }
    println file.text
    file.delete()
  }
  
  void script(closure) {
      closure.delegate = script
      closure( )
  }  
  
  void assertUWSC(closure) {
      closure.delegate = assertUWSC
      closure()
  }
  
  static String getCommands(){
      def commands = []
      commands << script.getCommands() << assertUWSC.getCommands()
      return commands.join(System.getProperty('line.separator'))
  }
}
