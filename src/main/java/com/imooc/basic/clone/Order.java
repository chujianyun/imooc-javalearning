package com.imooc.basic.clone;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order implements Cloneable, Serializable {

    private static final long serialVersionUID = 3602391488833845639L;
    private Long id;

    private String orderNo;

    private List<Item> itemList;

    @Override
    public Order clone() {
        try {
            Order order = (Order) super.clone();
            order.id = new Long(id);
            order.orderNo = new String(orderNo);
            List<Item> items = new ArrayList<>();
            order.setItemList(items);
            if (CollectionUtils.isNotEmpty(itemList)) {
                for (Item each : itemList) {
                    Item item = new Item();
                    item.setId(new Long(each.getId()));
                    item.setItemId(new Long(each.getItemId()));
                    item.setName(new String(each.getName()));
                    item.setDesc(new String(each.getDesc()));
                    items.add(item);
                }
            }
            return order;
        } catch (CloneNotSupportedException ignore) {

        }

        return null;
    }
}
