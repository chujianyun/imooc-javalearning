package com.imooc.basic.clone;

import java.util.ArrayList;
import java.util.List;

public class OrderMocker {

    public static Order mock() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("abcdefj");
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setId(0L);
        item.setItemId(0L);
        item.setName("xx慕课专栏");
        item.setDesc("精品推荐");
        items.add(item);
        order.setItemList(items);
        return order;
    }
}
