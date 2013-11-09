UWSTTester
==========

UWSTを使ったUIテストを実行するツール

※数値付きリストの項番が全て１なのはMarkdown力の無さ故です。
ごめんなさいです。


USAGE
=====


1. ソースをローカルにクローンする

```
git clone http://10.146.225.140:8008/gitbucket/git/nemoto/UWSCTester.git
```

2. UWSC.exeへのパスを編集（この手順は後々削除したい）

チェックアウトしたプロジェクトのsrc / main / groovy / org / kaakaa / uwsc / exec / Executer.groovy 内の
UWSC.exeファイルへのパスを自分の環境に合うように設定する

3. ビルド

プロジェクトのトップディレクトリで下記コマンドを実行する。
（Gradle Wrapperを使用しているのでGradleをインストールする必要はありません。
ただビルドに必要な情報をダウンロードするため、多少時間がかかります。）

```
gradlew.bat jar
```

4. テスト実行

バッチを起動するとサンプルプログラムが走ります。
（notepadを起動して、そのウィンドウタイトルをテストするスクリプト）

```
exec.bat
```

HOW TO WRITE TEST CODE
======================

基本的にはサンプルのuwsc.groovyを参考に。
テストスクリプトは「script」ブロックと「assert」ブロックに大別される

「script」ブロックで指定されたUWSCスクリプトを実行し、実行後に選択されているアクティブウィンドウに対して
「assert」ブロックに記述したテストを実行するイメージ

SCRIPT
------

スクリプトブロックで実行するスクリプトの指定方法は２種類ある。

1. UWSCスクリプト直接指定

スクリプトブロック内に"$" で始まる行を追加すると、そこにはUWSCスクリプトを直接記述できる

```
script {
	$ MMV(1659,1119,10)
	$ KBD(VK_D,UP,94)
}
```

2. UWSCスクリプトファイル指定

"f"で始まる行では、UWSCスクリプトファイルを指定することができる。

また、ファイルを指定する場合、第２引数としてtrueを指定するとUWSCでのマウス移動コマンド（MMV）を
省略した形でスクリプトを実行できる

```
script {
	$ MMV(1659,1119,10)
	$ KBD(VK_D,UP,94)
	f "${new File('.','sample.UWS').absolutePath", true
}
```

ASSERT
------

「scirpt」ブロックに記述された後にアクティブな状態となっているウィンドウに対する
Assertionを記述するブロック。

※現状ではassertTitleぐらいしかまともに動作しません。

1. assertTitle

assertTitleの引数として予測値を指定する

```
assertUWSC {
	assertTitle('無題 - メモ帳')
}
```


TODO
====

- Test Suite機能
- 結果出力について
- UWSC.Testという書き方でなく、もっと簡略かした「tests」「test」という書き方ができるようにする
- UWSC.exeの指定方法の簡略化
