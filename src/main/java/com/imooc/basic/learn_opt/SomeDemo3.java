package com.imooc.basic.learn_opt;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SomeDemo3 {

    private static volatile Map<String, List<String>> images;


    private Map<String, List<String>> getMapData() {
        if (images == null) {
            synchronized (SomeDemo3.class) {
                if (images == null) {
                    Map<String, List<String>> inner = new HashMap<>();
                    List<String> first = new ArrayList<>();
                    first.add("http://xxxxxximg1.png");
                    first.add("http://xxxxxximg2.png");
                    // 省略其他
                    List<String> second = new ArrayList<>();
                    second.add("http://yyyyimg1.png");
                    second.add("http://yyyyimg2.png");
                    // 省略其他
                    inner.put("10*20", first);
                    inner.put("10*30", second);
                    images = Collections.unmodifiableMap(inner);
                }
            }
        }
        return images;
    }


    public List<String> getImages(String type) {
        if (StringUtils.isBlank(type)) {
            return new ArrayList<>();
        }
        return images.getOrDefault(type, new ArrayList<>());
    }
}
