package com.imooc.basic.learn_list;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCalDemo {

    public static void main(String[] args) {



        List<Integer> integers1 = Lists.newArrayList(1, 2);

        List<Integer> integers2 = Lists.newArrayList(1, 2, 3);

        List<Integer> intersection = ListUtils.intersection(integers1, integers2);
        System.out.println(intersection);

        List<Integer> union = ListUtils.union(integers1, integers2);
        System.out.println(union);

    }
}
