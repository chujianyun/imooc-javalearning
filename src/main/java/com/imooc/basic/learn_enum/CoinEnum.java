package com.imooc.basic.learn_enum;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CoinEnum {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25)/*,NEWONE(50)*/;

    CoinEnum(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }

    private static final Map<Integer, CoinEnum> cache = new HashMap<>();

    static {
        for (CoinEnum coinEnum : CoinEnum.values()) {
            cache.put(coinEnum.getValue(), coinEnum);
        }
    }

    public static CoinEnum getEnum(int value) {
        return cache.getOrDefault(value, null);
    }
}



