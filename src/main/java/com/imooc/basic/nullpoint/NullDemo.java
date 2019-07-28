package com.imooc.basic.nullpoint;


import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NullDemo {

    public static void doSomething5(@NonNull String param) {
        // 使用param
        proccess(param);
    }

    public static void doSomething6(@Nullable String param) {
        // 使用param
        proccess(param);
    }

    public static void doSomething7(@NotNull String param) {
        // 使用param
        proccess(param);
    }

    private static void proccess(String param) {
        System.out.println(param);
    }


    public static void doSomething(String param) {
        if (StringUtils.isNotEmpty(param)) {
            // 使用param参数
        }
    }

    public static void doSomething2(List<String> parms) {
        Validate.notEmpty(parms);
    }

    public void doSomething(List<String> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            // 使用params
        }
    }

}
