package com.imooc.basic.nullpoint;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodCreateParam implements Serializable {

    private static final long serialVersionUID = -560222124628416274L;
    private String title;

    private long price;

    private long count;
}
