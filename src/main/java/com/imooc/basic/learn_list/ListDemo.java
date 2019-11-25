package com.imooc.basic.learn_list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {

    public static void main(String[] args) {

        List<SimpleObject> data = new ArrayList<>();
        data.add(new SimpleObject("a", 1));
        data.add(new SimpleObject("b", 2));
        data.add(new SimpleObject("c", 2));
        data.add(new SimpleObject("c", 3));

        Map<String, Integer> result = getResult(data);
        System.out.println(result);
    }

    private static Map<String, Integer> getResult(List<SimpleObject> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new HashMap<>(0);
        }
        return data.stream()
                .filter(Objects::nonNull)
                .filter(obj -> Objects.nonNull(obj.getValue()))
                .collect(Collectors.toMap(SimpleObject::getName, SimpleObject::getValue,
                        Integer::sum));
    }
}
