package com.imooc.basic.debug;

import com.imooc.basic.clone.Item;
import com.imooc.basic.clone.Order;
import com.imooc.basic.clone.OrderMocker;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class OrderDebug {

    public static void main(String[] args) {
        StringUtils.firstNonBlank();

        Order order = OrderMocker.mock();

        // 省略 N 行代码
        List<Item> itemList = order.getItemList();
        for(Item item : itemList){
            System.out.println(item);
        }
    }
}
