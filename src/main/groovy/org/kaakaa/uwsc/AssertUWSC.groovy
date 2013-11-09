package org.kaakaa.uwsc;

import org.kaakaa.uwsc.assertion.*

class AssertUWSC {
    // FIXME create UWSCAssertion interface
	List<UWSCAssertion> assertions = []

    def assertTitle(String expected) {
    	assertions << new TitleAssertion(expected)
    }

    def assertClass(String expected) {
    	assertions << new ClassAssertion(expected)
    }

    def assertMessage(String expected) {
    	assertions << new MessageAssertion(expected)
    }

    def void assertUWSC(String windowsName, File logFile) {
    	assertions.each{
    		it.assertUWSC(windowsName)
    	}
    }
}
