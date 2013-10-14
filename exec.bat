set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8
java %JAVA_OPTS% -cp "./lib/groovy-all-2.1.5.jar;./build/libs/UWSCTester.jar" groovy.ui.GroovyMain uwsc.groovy