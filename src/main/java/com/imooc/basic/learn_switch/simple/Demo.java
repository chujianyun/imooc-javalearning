package com.imooc.basic.learn_switch.simple;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        User user = new User();
        user.setAge((short) 17);
        user.setMale(true);
        demo.some(user);
    }

    private void some(User user) {
        Short age = user.getAge();
        if (age < 18) {
            if (user.getMale()) {
                // 其他代码
                System.out.println("18岁 以下男性");
            } else {
                // 其他代码
                System.out.println("18岁 以下女性");
            }
        } else if (age <= 60) {
            if ("张三".equals(user.getName())) {
                // 其他代码
                System.out.println("18到60岁 张三");
            } else if ("李四".equals(user.getName())) {
                System.out.println("18到60岁 李四");
            } else {
                // 其他代码
                System.out.println("18到60岁 其他");
            }
        } else {
            System.out.println("60岁以上");
        }
    }
}
