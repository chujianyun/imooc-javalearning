package com.imooc.basic.learn_switch.improve;

import com.imooc.basic.learn_switch.simple.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class LessThan18Handler extends AbstractAgeHandler {

    // 存储策略
    private static final Map<Boolean, Runnable> SEX_STRATEGY_MAP = new HashMap<>();

    static {
        SEX_STRATEGY_MAP.put(Boolean.TRUE, () -> {
            // 一种处理策略
            System.out.println("小于18岁  男性");
        });

        SEX_STRATEGY_MAP.put(Boolean.FALSE, () -> {
            // 另外的处理策略
            System.out.println("小于18岁  女性");
        });

    }

    /**
     * 该条件的处理函数
     */
    @Override
    protected void doHandle(User user) {
        // 处理小于18岁的代码逻辑

        // 处理性别部分
        SEX_STRATEGY_MAP.get(user.getMale()).run();
    }

    /**
     * 条件18岁
     */
    @Override
    public Predicate<Short> getCondition() {
        return (age) -> age < 18;
    }
}
