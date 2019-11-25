package com.imooc.basic.learn_int;

public class ByteOperateDemo {

    public static void main(String[] args) {
        int i = -2;
        System.out.println("-2的二进制形式："+Integer.toBinaryString(i));
        int result = i >>> 3;
        System.out.println("-2>>>3 的二进制值："+Integer.toBinaryString(result));
        System.out.println("-2>>>3的十进制表示："+result);
    }
}
