import org.kaakaa.uwsc.AssertUWSC
import org.kaakaa.uwsc.Script
import org.kaakaa.uwsc.UWSC

UWSC.test {
    script {
        $ 'SEND_KEY("hoge")'
        $ 'SEND_KEY("fuga")'
    }
    assertUWSC {
        assertTitle('title')
    }
}
