package com.imooc.basic.serial.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * JSON序列化工具
 */
public class GSONSerialUtil {

    public static <T> String getJsonString(T data) {
        return new Gson().toJson(data);
    }

    public static <T> T parseJson(String jsonString, Type typeOfT) {
        return new Gson().fromJson(jsonString, typeOfT);
    }
}
