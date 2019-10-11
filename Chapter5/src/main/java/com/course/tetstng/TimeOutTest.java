package com.course.tetstng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        System.out.println("testSuccess");
        Thread.sleep(2000);
        System.out.println("testSuccess wake");
    }

    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        System.out.println("testFailed");
        Thread.sleep(3000);
        System.out.println("testFailed wake");
    }
}
