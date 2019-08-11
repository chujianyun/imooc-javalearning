package com.imooc.basic.learn_switch;

public class SwitchTest {

    public static void main(String[] args) {

        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    // 等价的函数
    private static void same() {
        String param = null;
        int hashCode = param.hashCode();
        if(hashCode == ("null").hashCode() && param.equals("null")){
            System.out.println("null");
        }else{
            System.out.println("default");
        }
    }
}
