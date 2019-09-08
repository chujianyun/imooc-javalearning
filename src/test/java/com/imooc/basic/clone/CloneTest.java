package com.imooc.basic.clone;

import com.imooc.basic.clone.util.CloneUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
public class CloneTest {

 /*   @Test
    public void shallowClone() {
        Order order = OrderMocker.mock();
        Order cloneOrder = (Order) order.clone();

        assertFalse(order == cloneOrder);
        assertTrue(order.getId() == cloneOrder.getId());
        assertTrue(order.getOrderNo() == cloneOrder.getOrderNo());
        assertTrue(order.getItemList() == cloneOrder.getItemList());
    }*/

    @Test
    public void deepClone() {
        Order order = OrderMocker.mock();
        Order cloneOrder = (Order) order.clone();

        assertFalse(order == cloneOrder);
        assertFalse(order.getId() == cloneOrder.getId());
        assertFalse(order.getOrderNo() == cloneOrder.getOrderNo());
        assertFalse(order.getItemList() == cloneOrder.getItemList());
    }

    @Test
    public void withSerializationUtils() {
        Order order = OrderMocker.mock();
        Order cloneOrder = SerializationUtils.clone(order);

        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
    }

    @Test
    public void withGson() {

        Order order = OrderMocker.mock();
        // gson序列化方式
        Order cloneOrder = CloneUtil.deepCloneByGson(order, Order.class);

        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
    }
}
