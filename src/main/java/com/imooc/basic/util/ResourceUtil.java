package com.imooc.basic.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;

public class ResourceUtil {

    public static <T> T parseJson(Class<T> tClass, String resourcePath) {
        URL resource = tClass.getResource(resourcePath);
        if (resource == null) {
            throw new IllegalArgumentException("no such json file");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(resource.getFile())))) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String string = stringBuilder.toString();
            return JSON.parseObject(string, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
