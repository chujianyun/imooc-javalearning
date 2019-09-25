package com.imooc.basic.lean_exception;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) throws InterruptedException {

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("ab");
        data.add("abc");
        data.add("abcd");
        try {
            for (String str : data) {
                // 远程方法调用（可能出现异常）
                String result = doSomeRemoteInvoke(str);
                System.out.println(result);
            }
        } catch (Exception e) {
            log.error("程序出错，参数data:{},错误详情", JSON.toJSONString(data), e);
        }

        // printList1(data, executorService);
        // printList2(data, executorService);
    }

    private static String doSomeRemoteInvoke(String str) {
        if (str.length() == 2) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    private static void printList1(List<String> data, ExecutorService executorService) {
        Preconditions.checkNotNull(data);

        for (String str : data) {
            executorService.execute(() -> {
                // 模拟中间报错
                if (str.length() == 2) {
                    throw new IllegalArgumentException();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + str);
            });
        }
    }

    private static void printList2(List<String> data, ExecutorService executorService) {
        executorService.execute(() -> {


        });
    }
}
