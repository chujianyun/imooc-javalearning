package com.imooc.basic.learn_switch.improve;

import com.imooc.basic.learn_switch.simple.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Between18And60Handler extends AbstractAgeHandler {
    // 存储策略
    private static final Map<String, Runnable> NAME_STRATEGY_MAP = new HashMap<>();

    static {
        NAME_STRATEGY_MAP.put("张三", () -> {
            // 一种处理策略
            System.out.println("18到60岁 张三");
        });

        NAME_STRATEGY_MAP.put("李四", () -> {
            // 另外的处理策略
            System.out.println("18到60岁 李四");
        });

    }

    /**
     * 该条件的处理函数
     */
    @Override
    protected void doHandle(User user) {
        // 处理18 到60岁的代码逻辑

        // 处理性别部分
        Runnable runnable = NAME_STRATEGY_MAP.get(user.getName());
        if (runnable != null) {
            runnable.run();
        } else {
            System.out.println("18到60岁 其他");
        }
    }

    /**
     * 条件18岁
     */
    @Override
    public Predicate<Short> getCondition() {
        return (age) -> age >= 18 && age <= 60;
    }
}
