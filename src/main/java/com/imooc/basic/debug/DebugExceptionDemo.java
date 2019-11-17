package com.imooc.basic.debug;

import org.apache.commons.lang3.RandomUtils;

public class DebugDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            some(i);
        }
    }

    /**
     * 待研究的函数
     */
    private static void some(int i) {
        if (RandomUtils.nextBoolean()) {
            other();
        }
    }

    /**
     * 模拟一个非常复杂的函数
     */
    private static void other() {
        if (RandomUtils.nextInt(0, 60) > 50) {
            throw new IllegalArgumentException("错了");
        }
    }
}
