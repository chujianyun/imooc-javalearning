package com.imooc.basic.varargs;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class VarargsTest {

    @Test
    public void format() {
        String pattern = "我喜欢编程";
        String format = String.format(pattern);

        String expected = pattern;
        Assert.assertEquals(expected, format);
    }

    @Test
    public void format2() {
        String pattern = "我喜欢在 %s 上学习 %s";
        String arg0 = "https://www.imooc.com/";
        String arg1 = "编程";
        String format = String.format(pattern, arg0, arg1);

        String expected = "我喜欢在 " + arg0 + " 上学习 " + arg1;
        Assert.assertEquals(expected, format);
    }

    @Test
    public void isAllEmpty() {
        boolean result = StringUtils.isAllEmpty();
        Assert.assertFalse(!result);
    }
}
