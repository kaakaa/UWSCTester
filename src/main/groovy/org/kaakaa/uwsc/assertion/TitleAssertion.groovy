package org.kaakaa.uwsc.assertion

import org.kaakaa.uwsc.exec.Executer

class TitleAssertion implements UWSCAssertion {

	final String expected

	def TitleAssertion(String expected) {
		println expected
		this.expected = expected
	}

	def void assertUWSC(String windowName){
		println this.expected
		def logFile = File.createTempFile("AssertTitle",".log")
		def command = []
		command << "Option LogPath=\"${logFile.absolutePath}\""
		command << "Option LogFile=2"
		command << "PRINT STATUS(GETID(\"${rstrip(windowName)}\"), ST_TITLE)"
		def scriptFile = File.createTempFile("TitleAssertion",".UWS")
		scriptFile.write(command.join(System.getProperty('line.separator')))
		Executer.exec(scriptFile)
		scriptFile.delete()

		assert rstrip(logFile.getText('utf-8')).getBytes('utf-8') == this.expected.getBytes('utf-8')
		logFile.delete()
	}

	def rstrip(str) {
		str.replaceAll(/\s+\z/,"")
	}
}