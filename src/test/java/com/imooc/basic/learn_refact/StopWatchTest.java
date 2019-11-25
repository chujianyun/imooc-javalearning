package com.imooc.basic.learn_refact;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {

    @Test
    public void useTimeStamp() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 一些代码
        System.out.println("这里模拟N行代码");


        Thread.sleep(1 * 1000*60);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void useStopWatch() throws InterruptedException {
        StopWatch stopWatch = StopWatch.createStarted();
        //  这里模拟代码运行
        TimeUnit.MINUTES.sleep(1);

        System.out.println(stopWatch.getTime());
    }
}
