package com.imooc.basic.learn_switch;

public class SwitchTest3 {
    public static void main(String[] args) {
        String param = null;
        switch (param = "null") {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
