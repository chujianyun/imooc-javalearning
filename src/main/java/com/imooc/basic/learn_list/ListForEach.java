package com.imooc.basic.learn_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListForEach {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("b");
        for (String datum : data) {
            System.out.println(datum);
        }
    }
}
