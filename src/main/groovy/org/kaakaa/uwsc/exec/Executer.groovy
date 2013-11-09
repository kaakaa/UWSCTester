package org.kaakaa.uwsc.exec

class Executer {

    // FIXME avoid hard coding
	static final String UWSC_EXE = "C:\\Program Files (x86)\\uwsc\\UWSC.exe"
	
	static String exec(File script) {
		/"${UWSC_EXE}" "${script.getAbsolutePath()}"/.execute().waitFor()
	}
}