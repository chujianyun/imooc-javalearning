package com.imooc.basic.serial.entity;

import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * 用户
 */
@Data
public class PersonExternalizable implements Externalizable {

    private Long id;

    private String name;

    private Boolean male;

    private List<PersonExternalizable> friends;

    private transient Address address;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this);
        // 直接写报序列化错误（可以写JSON串，再反序列化）
        out.writeObject(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readObject();
        this.address = (Address) in.readObject();
    }
}
