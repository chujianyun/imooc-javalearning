package com.imooc.basic.learn_source_code.local;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("b");
        for (String str : data) {
            System.out.println(str);
        }
    }
}
