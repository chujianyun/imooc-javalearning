package com.imooc.basic.serial.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;

public class FastJsonUtil {

    public static <T> String getJsonString(T data) {
        return JSON.toJSONString(data);
    }


    public static <T> T parseJson(String jsonString, Type typeOfT) {
        return JSON.parseObject(jsonString, typeOfT);
    }

    public static <T> T parseJson(Map<String,Object> map, Type typeOfT) {
        return new JSONObject(map).toJavaObject(typeOfT);
    }

}
