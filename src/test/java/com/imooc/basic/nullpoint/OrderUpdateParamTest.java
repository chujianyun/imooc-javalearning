package com.imooc.basic.nullpoint;

import org.junit.Test;

public class OrderUpdateParamTest {
    @Test
    public void test() {
        OrderService orderService = new OrderServiceImpl();

        OrderUpdateParam orderUpdateParam = new OrderUpdateParam();
        orderUpdateParam.setId(1024L);
        orderUpdateParam.setName("订单编号");
        // 其他属性设置

        // 更新订单
        orderService.updateOrder(orderUpdateParam);
    }

}