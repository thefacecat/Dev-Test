package com.course.tetstng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"name","age","salary"})
    public void paramTest1(String name,int age,int salary){
        System.out.println("name="+name+";age="+age+";salary=s"+salary);
    }
}
