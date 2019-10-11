package com.course.tetstng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupMethods {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是服务端的测试方法3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是服务端的测试方法4");
    }


    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前的方法");
    }


    @AfterGroups("server")
    public void afterGoupsOnServer(){
        System.out.println("这是服务端组运行之后的方法！！！");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端端组运行之前的方法");
    }


    @AfterGroups("client")
    public void afterGoupsOnClient(){
        System.out.println("这是客户端组运行之后的方法！！！");
    }
}
