package com.imooc.basic.learn_switch.improve;

import com.imooc.basic.learn_switch.simple.User;

import java.util.function.Predicate;

public class MoreThan60Handler extends AbstractAgeHandler {


    @Override
    protected void doHandle(User user) {
        System.out.println("没有分支逻辑，支持处理");
    }

    @Override
    public Predicate<Short> getCondition() {
        return (age) -> age > 60;
    }
}
