package org.kaakaa.uwsc;

class AssertUWSC {
	List<String> commands = []

    def assertTitle(String expected) {
    	commands << "PRINT STATUS(GETID(GET_ACTIVE_WIN), ST_TITLE) + \"${expected}\""
    }

    def String getCommands(){
      return commands.join(System.getProperty('line.separator'))
    }

}
