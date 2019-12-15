package com.imooc.basic.learn_enum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class EnumTest2 {



    @Test
    public void test() {
        int key = 5;

        CoinEnum targetEnum = CoinEnum.NICKEL;

       /* CoinEnum anEnum = CoinEnum.getEnum(key);
        Assert.assertEquals(targetEnum, anEnum);

        // 使用缓存
        Optional<CoinEnum> enumWithCache = EnumUtils.getEnumWithCache(CoinEnum.class, CoinEnum::getValue, key);
        Assert.assertTrue(enumWithCache.isPresent());
        Assert.assertEquals(targetEnum, enumWithCache.get());

        // 不使用缓存（遍历）
        Optional<CoinEnum> enumResult = EnumUtils.getEnum(CoinEnum.class, CoinEnum::getValue, key);
        Assert.assertTrue(enumResult.isPresent());
        Assert.assertEquals(targetEnum, enumResult.get());*/
    }

}
