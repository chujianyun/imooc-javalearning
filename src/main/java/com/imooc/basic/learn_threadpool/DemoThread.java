package com.imooc.basic.learn_threadpool;

import java.util.concurrent.TimeUnit;

public class DemoThread extends Thread {


    public DemoThread() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ignore) {
            }
        }
    }

}
