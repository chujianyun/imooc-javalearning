package com.imooc.basic.learn_enum;

import java.util.Objects;

public interface Enum {

    Object getValue();

    default boolean valueEquals(Object value) {
        Object enumValue = getValue();
        return Objects.deepEquals(enumValue, value);
    }

}
