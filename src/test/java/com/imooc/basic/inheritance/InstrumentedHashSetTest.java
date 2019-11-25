package com.imooc.basic.inheritance;

import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class InstrumentedHashSetTest {

    @Test
    public void testAddCount() {
        List<String> stringList = Arrays.asList("Snap", "Crackle", "Pop");
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(stringList);

        s.removeIf(next -> StringUtils.isNotBlank(next) && next.length() > 3);
        System.out.println(s);

        // Assert.assertEquals(stringList.size(), s.getAddCount());
    }
}