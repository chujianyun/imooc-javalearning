package com.imooc.basic.serial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Address implements Serializable {
    private static final long serialVersionUID = -7430406639832953531L;

    private String detail;
}
