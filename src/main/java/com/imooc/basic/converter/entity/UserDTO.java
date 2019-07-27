package com.imooc.basic.converter.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String name;
    private Integer age;
    private String nickName;
    private Date birthDay;
}
