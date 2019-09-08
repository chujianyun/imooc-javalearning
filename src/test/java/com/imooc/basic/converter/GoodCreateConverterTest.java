package com.imooc.basic.converter;

import com.alibaba.fastjson.JSON;
import com.imooc.basic.nullpoint.GoodCreateDTO;
import com.imooc.basic.nullpoint.GoodCreateParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class GoodCreateConverterTest {

    @Test
    public void convertToParam() {
        GoodCreateDTO createDTO = new GoodCreateDTO();
        createDTO.setTitle("慕课出品");
        createDTO.setPrice(1024L);

        GoodCreateParam goodCreateParam = GoodCreateConverter.convertToParam(createDTO);
        log.info(JSON.toJSONString(goodCreateParam));

    }
}