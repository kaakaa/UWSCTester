UWSC.test {
    script {
        $ 'SEND_KEY("hoge")'
        $ 'SEND_KEY("fuga")'
    }
    assertUWSC {
        assertTitle('title')
    }
}

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

class Script {
    List<String> commands = []
    
    // add uwsc command
    def $(String command) {
        commands << command
    }
    
    // read uwsc script file
    def F(String path){
        commands << Arrays.asList(new File(path).text.split(System.property('line.separator')))
    }
    
    def String getCommands(){
      return 'script'
    }
}

class AssertUWSC {
    def assertTitle(String expected) {
    }

    def String getCommands(){
      return 'assertUWSC'
    }
}
