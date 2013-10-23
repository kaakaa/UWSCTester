package org.kaakaa.uwsc

class UwscMain {
	public static void main(String[] args){
		def  dsl = new File('uwsc.groovy').text
		def script = """
			${dsl}
		"""

		new GroovyShell().evaluate(script)
	}
}
