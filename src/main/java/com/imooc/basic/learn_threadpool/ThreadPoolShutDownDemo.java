package com.imooc.basic.learn_threadpool;

import com.imooc.basic.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolShutDownDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(50000), new NamedThreadFactory("shutdown-demo"));

        int total = 20000;
        for (int i = 0; i < total; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(5L);
                } catch (InterruptedException ignore) {
                }
                //System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdownNow();
        printExecutorInfo(total, executorService);

       // executorService.shutdown();

     /* shutdown()之后再提交任务
        executorService.submit(() -> {
        });*/

        // 线程池没结束，隔一秒打印任务情况
        while (!executorService.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
            printExecutorInfo(total, executorService);
        }
    }

    /**
     * 打印线程池信息
     */
    private static void printExecutorInfo(int total, ThreadPoolExecutor executorService) {
        String dateString = DateUtil.toDateString(LocalDateTime.now(ZoneId.systemDefault()));
        log.debug("时间:{},总任务数：{}, 工作队列中有:{}个任务，已完成:{}个任务，正在执行:{}个任务", dateString, total, executorService.getQueue().size(), executorService.getCompletedTaskCount(), executorService.getActiveCount());
    }
}
