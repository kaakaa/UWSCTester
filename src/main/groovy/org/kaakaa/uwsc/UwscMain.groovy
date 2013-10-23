package org.kaakaa.uwsc

class UwscMain {
	public static void main(String[] args){
		def dsl = new File('uwsc.groovy').text
		def dslDef = UwscMain.class.getClassLoader().getResource('org/kaakaa/uwsc/ExecuteTest.groovy').text
		def script = """
			${dsl}
			${dslDef}
		"""

		new GroovyShell().evaluate(script)
	}
}
