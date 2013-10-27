package org.kaakaa.uwsc.exec

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.kaakaa.uwsc.UWSC

/**
 * Created with IntelliJ IDEA.
 * User: kaakaa_hoe
 * Date: 13/10/27
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Parameterized.class)
class UWSCTestExecuter {
    private static List<Object[]> list

    @Parameterized.Parameters(name="{0} is executing")
    public static List<Object[]> getParameters(){
        return list;
    }

    def static void setList(List<Object[]> objList){
        list = objList
    }

    private final UWSC uwsc;

    public UWSCTestExecuter(String name, UWSC uwsc){
        this.uwsc = uwsc;
    }

    @Test
    public void testUI(){
       uwsc.test()
    }
}

