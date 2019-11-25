package com.imooc.basic.debug;

import org.apache.commons.lang3.RandomUtils;

public class DebugConditionDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 100L; i++) {
            some((long) i);
        }
    }

    /**
     * 待研究的函数
     */
    private static void some(Long userId) {
        if (RandomUtils.nextBoolean()) {
            System.out.println(userId);
        }
    }
}
