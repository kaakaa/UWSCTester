import org.kaakaa.uwsc.UWSC

class ExecuteTest {
	def uwsc(closure){
		def uwsc = new UWSC()
		closure.delegate = uwsc
		closure()

		uwsc.test()
	}
}

def getTest(){
	test = new ExecuteTest()
}