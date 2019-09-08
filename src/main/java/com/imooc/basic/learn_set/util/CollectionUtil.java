package com.imooc.basic.learn_set.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionUtil {


    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }

}
