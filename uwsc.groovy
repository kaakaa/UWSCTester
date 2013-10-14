import org.kaakaa.uwsc.AssertUWSC
import org.kaakaa.uwsc.Script
import org.kaakaa.uwsc.UWSC

encoding = 'utf-8'

UWSC.test {
    script {
        f "C:\\Program Files (x86)\\uwsc\\sample.UWS", true
    }
    assertUWSC {
        assertTitle('無題 - メモ帳')
        //assertMessage('hoge')
        //assertClass('hoge')
    }
}
