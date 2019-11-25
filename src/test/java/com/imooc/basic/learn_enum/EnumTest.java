package com.imooc.basic.learn_enum;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@Slf4j
public class EnumTest {

    /**
     * 硬币值，对应的枚举参见{@link CoinEnum}
     */
    private Integer coinValue;

    private File file = new File("coinEnum.dat");

    @Test
    public void testValues() {
        CoinEnum[] values1 = CoinEnum.values();
        values1[0] = CoinEnum.QUARTER;

        CoinEnum[] values2 = CoinEnum.values();
        assertEquals(values2[0], CoinEnum.PENNY);
    }

    @Test
    public void serialTest() {
        CoinEnum[] values = CoinEnum.values();
        // 序列化
        byte[] serialize = SerializationUtils.serialize(values);

        log.info("序列化后的字符：{}", new String(serialize));
        // 反序列化
        CoinEnum[] values2 = SerializationUtils.deserialize(serialize);

        assertTrue(Objects.deepEquals(values, values2));
    }


    /**
     * 先运行将新增的枚举常量序列化
     * {@link CoinEnum.NEWONE}
     */
    @Test
    public void serialNewOne() throws FileNotFoundException {
        // 序列化
        //SerializationUtils.serialize(CoinEnum.NEWONE, new FileOutputStream(file));
    }

    /**
     * 反序列化时注释掉新增的类型
     * {@link CoinEnum.NEWONE}
     */
    @Test
    public void deserialNewOne() throws FileNotFoundException {
        // 反序列化
        assertThrows(SerializationException.class, () -> {
            CoinEnum newOne = SerializationUtils.deserialize(new FileInputStream(file));
            log.debug(newOne.name());
        });
    }
}
