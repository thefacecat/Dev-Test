package com.course.tetstng;

import org.testng.annotations.Test;

public class DependTest {

    @Test(groups = "t1")
    public  void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public  void test2(){
        System.out.println("test2 run");
    }

    @Test(dependsOnGroups = "t1")
    public void test3(){
        System.out.println("test3 run");
    }
}
