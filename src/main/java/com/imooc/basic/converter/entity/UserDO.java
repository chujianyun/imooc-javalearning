package com.imooc.basic.converter.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {
    private Long id;
    private String name;
    private Integer age;
    private String nickName;
    private Date birthDay;
}
