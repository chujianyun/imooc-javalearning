package com.imooc.basic.learn_threadpool;


import org.junit.Test;

public class ThreadDemoTest {

    @Test
    public void test() throws InterruptedException {

        DemoThread demoThread1 = new DemoThread();
        DemoThread demoThread2 = new DemoThread();

        demoThread1.start();
        demoThread2.start();

        demoThread1.join();
        demoThread2.join();
    }
}
