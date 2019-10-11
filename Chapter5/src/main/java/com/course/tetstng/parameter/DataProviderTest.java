package com.course.tetstng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "datatest")
    public void testDataProvider(String name,int age){
        System.out.println("name = "+name+";age = "+age);
    }

    @DataProvider(name = "datatest")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"ZhaoJunjie",26},
                {"WangLin",25},
                {"Luck",0},
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1 方法 name="+name+"age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2 方法 name="+name+"age="+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"ZhaoJun",26},
                    {"Wanglin",25},
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"XXX",1000},
                    {"TTT",1001},
            };
        }

        return result;
    }
}
