encoding = 'utf-8'

test.uwsc {
    name "サンプルテスト"
    script {
        f "${new File('.','sample.UWS').absolutePath}", true
    }
    assertUWSC {
        assertTitle('無題 - メモ帳')
        assertMessage('')
        assertClass('Notepad')
    }
}
