package com.imooc.basic.debug;

public class DebugBackDemo {

    public static void main(String[] args) {
        some("demo");
    }

    private static void some(String param) {

        System.out.println(param);
        other(param + "some");
    }

    private static void other(String param) {
        System.out.println(param);
    }
}
