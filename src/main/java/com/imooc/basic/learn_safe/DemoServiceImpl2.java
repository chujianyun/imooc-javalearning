package com.imooc.basic.learn_safe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class DemoServiceImpl2 implements DemoService {

    private static List<String> data;

    static {
        data = new ArrayList<>();
        data.add("a");
        data.add("b");
        data.add("c");
        data = Collections.unmodifiableList(data);
    }

    @Override
    public List<String> getData(String param) {
        return null;
    }
}
