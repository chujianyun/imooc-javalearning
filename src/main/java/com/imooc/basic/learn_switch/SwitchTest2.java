package com.imooc.basic.learn_switch;

public class SwitchTest2 {

    public static void main(String[] args) {
        String a = null;
        System.out.println(a.hashCode());

        String param = "t";
        System.out.println(param.hashCode());
        switch (param) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            case "c":
                System.out.println("c");
                break;
            default:
                System.out.println("default");
        }
    }

}
