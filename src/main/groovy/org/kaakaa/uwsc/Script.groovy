package org.kaakaa.uwsc;

class Script {
    List<String> commands = []
    
    // add uwsc command
    def $(String command) {
        commands << command
    }
    
    // read uwsc script file
    def f(String path, boolean mmvIgonore = false){
        commands.addAll(Arrays.asList(new File(path).text.split(System.getProperty('line.separator'))).findAll{ !it.startsWith('MMV') })
    }
    
    def String getCommands(){
      return commands.join(System.getProperty('line.separator'))
    }
}
