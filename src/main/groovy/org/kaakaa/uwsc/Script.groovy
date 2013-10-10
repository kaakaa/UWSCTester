package org.kaakaa.uwsc;

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
