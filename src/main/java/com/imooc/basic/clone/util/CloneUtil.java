package com.imooc.basic.clone.util;

import com.google.gson.Gson;
import com.imooc.basic.clone.Order;
import com.imooc.basic.serial.util.JdkSerialUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CloneUtil {

    /**
     * JDK序列化方式深拷贝
     */
    public static <T> T deepClone(T origin) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
            objectOutputStream.writeObject(origin);
            objectOutputStream.flush();
        }
        byte[] bytes = outputStream.toByteArray();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);) {
            return JdkSerialUtil.readObject(inputStream);
        }
    }

    /**
     * Gson方式实现深拷贝
     */
    public static <T> T deepCloneByGson(T origin, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(origin), clazz);
    }


}
