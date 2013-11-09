package org.kaakaa.uwsc;

// TODO creat "file" method
class Script {
    List<String> commands = []

    void $(String command) {
        commands << command
    }
    
    // read uwsc script file
    void f(String path, boolean mmvIgonore = false){
        commands.addAll(Arrays.asList(new File(path).text.split(System.getProperty('line.separator'))).findAll{ !it.startsWith('MMV') })
    }

    def String getCommands(){
      return commands.join(System.getProperty('line.separator'))
    }
}
