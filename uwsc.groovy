import org.kaakaa.uwsc.AssertUWSC
import org.kaakaa.uwsc.Script
import org.kaakaa.uwsc.UWSC

UWSC.test {
    script {
        f "C:\\Program Files (x86)\\uwsc\\sample.UWS", true
    }
    assertUWSC {
        assertTitle('title')
    }
}
