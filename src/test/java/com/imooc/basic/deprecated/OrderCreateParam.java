package com.imooc.basic.deprecated;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 第一章  五节 过时类的处理方式
 */
@Slf4j
public class OrderCreateParam {

    /**
     * 原始过期类用法
     */
    @Test
    public void testEncodeAndDecode() {
        String url = "http://www.imooc.com/test?name=张三";
        String encode = URLEncoder.encode(url);
        log.debug("URL编码结果：" + encode);
        String decode = URLDecoder.decode(encode);
        log.debug("URL解码结果：" + decode);
    }

    /**
     * 改用新函数
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testEncodeAndDecodeNew() throws UnsupportedEncodingException {

        String url = "http://www.imooc.com/test?name=张三";
        String encode = URLEncoder.encode(url, Charsets.UTF_8.name());
        log.debug("URL编码结果：" + encode);
        String decode = URLDecoder.decode(encode, Charsets.UTF_8.name());
        log.debug("URL解码结果：" + decode);
    }

    @Test
    public void test(){
        List<OrderItemParam> orderItemParamList = new ArrayList<>(2);
        OrderItemParam orderItemParam = new OrderItemParam();
        orderItemParam.setName("商品1");
        orderItemParam.setCount(22);
        orderItemParamList.add(orderItemParam);

        OrderItemParam orderItemParam2 = new OrderItemParam();
        orderItemParam2.setName("商品2");
        orderItemParam2.setCount(33);
        orderItemParamList.add(orderItemParam2);

        log.debug(JSON.toJSONString(orderItemParamList));

    }
}
