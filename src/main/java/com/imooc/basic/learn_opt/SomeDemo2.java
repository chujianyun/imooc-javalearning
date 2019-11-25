package com.imooc.basic.learn_opt;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SomeDemo2 {

    public List<String> getImages(String type) {

        List<String> result = new ArrayList<>();

        if ("10*20".equals(type)) {

            result.add("http://xxxxxximg1.png");
            result.add("http://xxxxxximg2.png");
            // 省略其他
        } else if ("10*30".equals(type)) {
            result.add("http://yyyyimg1.png");
            result.add("http://yyyyimg2.png");
            // 省略其他
        }
        return result;
    }

}
