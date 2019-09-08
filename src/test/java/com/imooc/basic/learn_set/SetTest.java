package com.imooc.basic.learn_set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SetTest {

    @Test
    public void test() {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat(1, 2, "tomcat"));
        cats.add(new Cat(1, 2, "ketty"));

        assertEquals(2, cats.size());
    }

}