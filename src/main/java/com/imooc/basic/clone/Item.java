package com.imooc.basic.clone;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品信息
 */
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 4055677557220705002L;

    private Long id;

    private Long itemId;

    private String name;

    private String desc;

    // 省略其他
}
