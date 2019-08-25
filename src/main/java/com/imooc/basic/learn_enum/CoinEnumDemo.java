package com.imooc.basic.learn_enum;

public class CoinEnumDemo {
    public static void main(String[] args) {

        CoinEnum result = CoinEnum.getByValue(5);
        System.out.println(result);
    }
}
