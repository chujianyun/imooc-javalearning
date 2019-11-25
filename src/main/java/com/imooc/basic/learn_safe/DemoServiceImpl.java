package com.imooc.basic.learn_safe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DemoServiceImpl implements DemoService {

    private static List<String> data;

    private List<String> doGetData() {

        if (data == null) {
            data = new ArrayList<>();
            data.add("a");
            data.add("b");
            data.add("c");
        }
        return data;
    }

    @Override
    public List<String> getData(String param) {
        // 省略其他
        List<String> data = doGetData();
        // 省略其他
        return null;
    }
}
