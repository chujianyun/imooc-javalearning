package com.imooc.basic.serial.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
@Data
public class Person implements Serializable {

    private Long id;

    private String name;

    private Boolean male;

    private Address address;
}
