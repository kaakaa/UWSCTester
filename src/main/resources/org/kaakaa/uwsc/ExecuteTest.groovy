import org.junit.runner.JUnitCore
import org.kaakaa.uwsc.UWSC
import org.kaakaa.uwsc.exec.UWSCTestExecutor
import org.kaakaa.uwsc.test.UwscTestSuite

def test(closure){
    test = new ExecuteTest().uwsc(closure)
}

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
        UWSCTestExecutor.setList([
                [uwsc.name, uwsc] as Object[]
        ])
        JUnitCore.main(UwscTestSuite.class.getName())
        //uwsc.test()
	}
}
