package com.imooc.basic.learn_source_code.local;

import java.util.ArrayList;
import java.util.List;

public class ThisDemo {


    private List<String> data = new ArrayList<>();

    public void someMethod(String param) {

        if (data != null && data.size() > 0 && data.contains(param)) {
            System.out.println(data.indexOf(param));
        }

    }
}
