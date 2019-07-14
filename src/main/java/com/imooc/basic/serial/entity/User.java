package com.imooc.basic.serial.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private Boolean sex;

    private String nickName;

    private Date birthDay;

    private Double salary;
}
