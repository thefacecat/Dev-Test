package com.course.tetstng;

import org.testng.annotations.*;

public class BasicAnnotation {

//    最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.printf("BasicAnnotation testCase1 Thread Id : %s%n",Thread.currentThread().getId());
        System.out.println("这是testCase1");
    }

    @Test
    public void testCase2(){
        System.out.printf("BasicAnnotation testCase2 Thread Id : %s%n",Thread.currentThread().getId());
        System.out.println("这是testcase2");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("这是BeforeMethod");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("这是AfterMethod");
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("这是BeforeClass");
    }

    @AfterClass
    public void afterclass(){
        System.out.println("这是AfterClass");
    }

    @BeforeSuite
    public void beforesuite(){
        System.out.println("这是BeforeSuite");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("这是AfterSuite");
    }

}
