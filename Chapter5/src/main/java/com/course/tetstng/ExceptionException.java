package com.course.tetstng;

import org.testng.annotations.Test;

public class ExceptionException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){

        System.out.println("这是我的异常测试");
        throw new RuntimeException();

    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testException(){

        System.out.println("测试编写的异常");
        throw new RuntimeException();
    }
}
