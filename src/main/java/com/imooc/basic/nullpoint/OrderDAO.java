package com.imooc.basic.nullpoint;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 模拟
 */
public class OrderDAO {

    public List<Order> getByOrderName(String name) {
        if (StringUtils.isNotEmpty(name)) {
            return doGetByOrderName(name);
        }
        return Collections.emptyList();
    }

    private List<Order> doGetByOrderName(String name) {
        return Stream.of(new Order()).collect(Collectors.toList());
    }

    public Optional<Order> getByOrderId(Long orderId) {
        return Optional.ofNullable(doGetByOrderId(orderId));
    }

    /**
     * 根据订单编号查询订单
     *
     * @param orderNo 订单编号
     * @return 订单
     */
    public Order getByOrderNo(String orderNo) {

        if (StringUtils.isEmpty(orderNo)) {
            return new Order();
        }
        // 查询order
        return doGetByOrderNo(orderNo);
    }

    private Order doGetByOrderNo(String orderNo) {
        return new Order();
    }

    private Order doGetByOrderId(Long id) {
        if (id < 50) {
            return null;
        }
        return new Order();
    }
}
