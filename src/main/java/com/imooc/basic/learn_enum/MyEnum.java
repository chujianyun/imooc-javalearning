package com.imooc.basic.learn_enum;

public interface MyEnum<E> {

    /**
     * 获取key
     */
    E getKey();

    MyEnum[] values();

    default MyEnum getEnum(Object key, Class<? extends MyEnum> eEnum) {

        for (MyEnum currentEnum : values()) {
            if (currentEnum.getKey().equals(key)) {
                return currentEnum;
            }
        }
        throw new IllegalStateException("");
    }
}
