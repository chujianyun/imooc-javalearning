package com.imooc.basic.learn_safe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class DemoServiceImpl3 implements DemoService {

    private static final Object LOCK = new Object();
    private static volatile List<String> data;

    private List<String> doGetData() {

        if (data == null) {
            synchronized (LOCK) {
                if (data == null) {
                    ArrayList<String> inner = new ArrayList<>();
                    inner.add("a");
                    inner.add("b");
                    inner.add("c");
                    data = Collections.unmodifiableList(inner);
                }
            }
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
