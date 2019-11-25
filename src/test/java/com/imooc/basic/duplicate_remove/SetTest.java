package com.imooc.basic.duplicate_remove;

import com.imooc.basic.learn_set.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.randomizers.collection.ListRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

@Slf4j
public class SetTest {
    List<String> data;

    @BeforeAll
    public void init() throws InterruptedException {

        data.wait();
        ListRandomizer<String> listRandomizer = new ListRandomizer<>(new StringRandomizer(10, 100, 1000), 10000);
        data = listRandomizer.getRandomValue();
    }

    @Test
    public void setTest() {
        Set<String> strings = CollectionUtil.removeDuplicateBySet(data);
        log.debug("set去重后大小：" + strings.size());
    }


    @Test
    public void listTest() {
        List<String> strings = CollectionUtil.removeDuplicateByList(data);
        log.debug("list去重后大小：" + strings.size());
    }
}
