package com.imooc.basic.nullpoint;

import java.util.Objects;

public class OrderServiceImpl implements OrderService {

    @Override
    public void updateOrder(OrderUpdateParam orderUpdateParam) {
        checkUpdateParam(orderUpdateParam);
        doUpdate(orderUpdateParam);
    }

    private void checkUpdateParam(OrderUpdateParam orderUpdateParam) {
        if (orderUpdateParam == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        Long id = orderUpdateParam.getId();
        String name = orderUpdateParam.getName();
        if (id == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        if (name == null) {
            throw new IllegalArgumentException("name不能为空");
        }
    }

    private void checkUpdateParam2(OrderUpdateParam orderUpdateParam) {
        Objects.requireNonNull(orderUpdateParam);
        Objects.requireNonNull(orderUpdateParam.getId());
        Objects.requireNonNull(orderUpdateParam.getName());
    }

    private void doUpdate(OrderUpdateParam orderUpdateParam) {
        System.out.println("更新订单");
    }
}
