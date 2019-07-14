package com.imooc.basic.serial.entity.hessian;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonHessian implements Serializable {
    private Long id;

    private String name;

    private Boolean male;
}
