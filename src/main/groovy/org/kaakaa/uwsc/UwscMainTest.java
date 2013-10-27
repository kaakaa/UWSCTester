package org.kaakaa.uwsc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: kaakaa_hoe
 * Date: 13/10/26
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Parameterized.class)
public class UwscMainTest{
    public static List<Object[]> list;

    @Parameterized.Parameters(name="{0} plus {1} equals {2}")
    public static List<Object[]> getParameters(){
        return list;
    }

    public static void setList(List<Object[]> objList){
        list = objList;

    }

    private final int int1;
    private final int int2;
    private final int int3;

    public UwscMainTest(int int1, int int2, int int3){
        this.int1 = int1;
        this.int2 = int2;
        this.int3 = int3;
    }

    @Test
    public void test(){
        assertThat(this.int1 + this.int2, is(int3));
    }


}
