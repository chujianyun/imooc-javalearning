package com.imooc.basic.learn_switch.improve;

import com.imooc.basic.learn_switch.simple.User;

import java.util.function.Predicate;

public abstract class AbstractAgeHandler {

    /**
     * 下一个处理器
     */
    protected AbstractAgeHandler nextAgeHandler;

    /**
     * 设置下一个处理器
     */
    public void setNextAgeHandler(AbstractAgeHandler nextAgeHandler) {
        this.nextAgeHandler = nextAgeHandler;
    }

    public void handle(User user) {
        if (getCondition().test(user.getAge())) {
            doHandle(user);
        }
        if (nextAgeHandler != null) {
            nextAgeHandler.handle(user);
        }
    }

    /**
     * 实际处理函数
     */
    protected abstract void doHandle(User user);

    /**
     * 获取查询条件
     */
    public abstract Predicate<Short> getCondition();
}
