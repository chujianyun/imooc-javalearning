package com.imooc.basic.learn_threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException ignore) {
            }
            System.out.println("异步任务");
        });
        TimeUnit.SECONDS.sleep(5);
    }
}
