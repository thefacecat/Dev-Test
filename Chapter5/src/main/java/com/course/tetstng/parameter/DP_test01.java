package com.course.tetstng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DP_test01 {

    @Test(dataProvider = "M0")
    public void test(String name,String sex,int age){
        System.out.println("name: "+name);
        System.out.println("sex: "+sex);
        System.out.println("age: "+age);
    }

    @DataProvider(name = "M0")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"ZhaoJunjie","M",26},
                {"WangLin","W",25},
                {"Luck","M",0},
        };
        return o;
    }

    @DataProvider(name = "M")
    public Object[][] testData(Method method){
        Object[][] res = null;
        if (method.getName().equals("test1")){
            res = new Object[][] {
                    {"test1","man",26}
            };
        }else if(method.getName().equals("test2")){
            res = new Object[][] {
                    {"test2","woman",25}
            };
        };
        return res;
    }

    @Test(dataProvider = "M")
    public void test1(String name,String sex,int age){
        System.out.println("name: "+name);
        System.out.println("sex: "+sex);
        System.out.println("age: "+age);
    }

    @Test(dataProvider = "M")
    public void test2(String name,String sex,int age){
        System.out.println("name: "+name);
        System.out.println("sex: "+sex);
        System.out.println("age: "+age);
    }
}
