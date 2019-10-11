package com.course.tetstng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Param_test01 {

    @Test
    @Parameters({"name","age"})
    public void P_t01(String name,int age){
        System.out.println("P_t01");
        System.out.println("name="+name+"age="+age);
    }

    @Test
    @Parameters({"name","age"})
    public void P_t02(String name,int age){
        System.out.println("P_t02");
        System.out.println("name="+name+"age="+age);
    }

    @Test(enabled = false)
    @Parameters({"name","age"})
    public void P_t03(String name,int age){
        System.out.println("P_t03");
        System.out.println("name="+name+"age="+age);
    }


    @Test(enabled = true)
    @Parameters({"name","age","team"})
    public void P_t04(String name,int age,String team){
        System.out.println("P_t04");
        System.out.println("name="+name+"age="+age+"team="+team);
    }
}
