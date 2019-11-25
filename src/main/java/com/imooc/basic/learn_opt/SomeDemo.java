package com.imooc.basic.learn_opt;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SomeDemo {

    private static Map<String, List<String>> images;

    static {
        images = new HashMap<>();

        List<String> first = new ArrayList<>();
        first.add("http://xxxxxximg1.png");
        first.add("http://xxxxxximg2.png");
        // 省略其他
        List<String> second = new ArrayList<>();
        second.add("http://yyyyimg1.png");
        second.add("http://yyyyimg2.png");
        // 省略其他

        images.put("10*20", first);
        images.put("10*30", second);
        images = Collections.unmodifiableMap(images);
    }

    public List<String> getImages(String type) {
        if (StringUtils.isBlank(type)) {
            return new ArrayList<>();
        }
        return images.getOrDefault(type, new ArrayList<>());
    }
}
