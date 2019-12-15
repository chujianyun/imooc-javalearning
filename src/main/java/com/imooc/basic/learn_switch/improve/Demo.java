package com.imooc.basic.learn_switch.improve;

import com.imooc.basic.learn_switch.simple.User;

public class Demo {
    public static void main(String[] args) {

        // 构造年龄处理器
        AbstractAgeHandler first = new LessThan18Handler();
        AbstractAgeHandler second = new Between18And60Handler();
        AbstractAgeHandler third = new MoreThan60Handler();

        // 编排
        first.setNextAgeHandler(second);
        second.setNextAgeHandler(third);

        // 使用
        User user = new User();
        user.setAge((short) 19);
        user.setMale(true);

        first.handle(user);
    }
}
