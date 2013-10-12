package org.kaakaa.uwsc.exec

import groovy.util.logging.*
import java.util.logging.*

@Log
class Executer {
	static final Logger logger = Logger.getLogger(this.class.name)

	static final String UWSC_EXE = "C:\\Program Files (x86)\\uwsc\\UWSC.exe"
	
	static String exec(File script) {
		logger.info '==== Execute UWSC ===='
		/"${UWSC_EXE}" "${script.getAbsolutePath()}"/.execute().waitFor()
		logger.info '==== COMPLETE UWSC ===='
	}
}