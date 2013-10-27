package org.kaakaa.uwsc.test

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses
import org.kaakaa.uwsc.UwscMainTest
import org.kaakaa.uwsc.exec.UWSCTestExecuter

/**
 * Created with IntelliJ IDEA.
 * User: kaakaa_hoe
 * Date: 13/10/26
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Suite.class)
@SuiteClasses([UWSCTestExecuter.class, UwscMainTest.class])
class UwscTestSuite {
}
