package com.imooc.basic.learn_test;

import com.alibaba.fastjson.JSON;
import com.github.javafaker.Faker;
import com.imooc.basic.util.ResourceUtil;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
public class PdfUtilTest {

    private List<String> mockStrList;

    @Before
    public void init() {
        mockStrList = new ArrayList<>();
        final int size = 10;
        for (int i = 0; i < size; i++) {
            mockStrList.add("something" + i);
        }
    }

    private List<String> mockString() {
        List<java.lang.String> mockStrList = new ArrayList<>();
        final int size = 10;
        for (int i = 0; i < size; i++) {
            mockStrList.add("something" + i);
        }
        return mockStrList;
    }

    // 构造 faker对象，指定语言
    private static Faker faker = new Faker(new Locale("zh-CN"));

    private EasyRandom easyRandom = new EasyRandom();


    @Test
    public void testPdfData() {
        // 构造测试数据
        PdfData pdfData = easyRandom.nextObject(PdfData.class);
        System.out.println(JSON.toJSONString(pdfData));

        log.info("构造的数据:{}", JSON.toJSONString(pdfData));

        // 测试export 函数
        Boolean export = PdfUtil.export(pdfData);
        Assert.assertTrue(export);
    }



/*    @Test
    public void test() {
        // 模拟姓名
        String name = faker.name().fullName();
        log.info("构造的数据:{}", name);
        Assert.assertNotNull(name);
    }*/


   /* private PdfData mockPdfData() {
        // 使用插件填充PdfData
        PdfData pdfData = new PdfData();

        pdfData.setId(0);
        pdfData.setName("some");
        pdfData.setWaterMark("test");
        pdfData.setPages(4);
        // 再次使用一次插件，填充PdfAttribute
        PdfAttribute pdfAttribute = new PdfAttribute();
        pdfAttribute.setWeight(1024L);
        pdfAttribute.setHeight(512L);
        pdfData.setPdfAttribute(pdfAttribute);
        return pdfData;
    }*/


}
