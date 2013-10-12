package org.kaakaa.uwsc;

import org.kaakaa.uwsc.assertion.*

class AssertUWSC {
	List<UWSCAssertion> assertions = []

    def assertTitle(String expected) {
    	assertions << new TitleAssertion(expected)
    }

    def void assertUWSC(String windowsName, File logFile) {
    	assertions.each{
    		it.assertUWSC(windowsName)
    	}
    }
}
