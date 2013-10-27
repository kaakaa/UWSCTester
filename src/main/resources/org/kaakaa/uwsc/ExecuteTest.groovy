import org.junit.runner.JUnitCore
import org.junit.runner.Result
import org.kaakaa.uwsc.UWSC
import org.kaakaa.uwsc.UwscMainTest
import org.kaakaa.uwsc.exec.UWSCTestExecuter
import org.kaakaa.uwsc.test.UwscTestSuite

class ExecuteTest {
	def uwsc(closure){
		def uwsc = new UWSC()
		closure.delegate = uwsc
		closure()

        UwscMainTest.setList([
            [1, 1, 2] as Object[],
            [1, 2, 3] as Object[],
            [1, 3, 4] as Object[]
        ]);
        UWSCTestExecuter.setList([
                [uwsc] as Object[]
        ])
        JUnitCore.main(UwscTestSuite.class.getName())
        //uwsc.test()
	}
}

def getTest(){
	test = new ExecuteTest()
}