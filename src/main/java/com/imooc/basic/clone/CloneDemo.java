package com.imooc.basic.clone;

import com.imooc.basic.clone.util.CloneUtil;
import com.imooc.basic.serial.entity.User;
import com.imooc.basic.serial.util.JdkSerialUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Order order = OrderMocker.mock();
        order.setOrderNo("first");
        executorService.execute(() -> doSomeThing(order));

        Order clone = CloneUtil.deepClone(order);
        clone.setOrderNo("second");
        executorService.execute(() -> doSomeThing(clone));

    }

    private static void doSomeThing(Order order) {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(order.getOrderNo());
    }
}
