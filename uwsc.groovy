import org.kaakaa.uwsc.AssertUWSC
import org.kaakaa.uwsc.Script
import org.kaakaa.uwsc.UWSC

encoding = 'utf-8'

UWSC.test {
    script {
        f "${new File('.','sample.UWS').absolutePath}", true
    }
    assertUWSC {
        assertTitle('無題 - メモ帳')
        assertMessage('')
        assertClass('Notepad')
    }
}
