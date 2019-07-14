package com.imooc.basic.serial.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 序列化时间
 */
@Data
public class SerialData {

    private Long start;

    private Long serialOver;

    private Long getByteOver;

    /**
     * 字节数
     */
    private Integer bytes;

    private Long unSerialOver;

    public Long getSerialTime() {
        return serialOver - start;
    }

    public Long getByteTime() {
        return getByteOver - serialOver;
    }

    public Long getUnSerialTime() {
        return unSerialOver - getByteOver;
    }

    public Long serialAndUnserial() {
        return getSerialTime() + getUnSerialTime();
    }

    @Override
    public String toString() {

        return new StringBuilder()
                .append("[")
                .append("序列化时间" + getSerialTime()+" ms")
                .append(",")
                .append("字节数" + getBytes()/1024+"K")
                .append(",")
                .append("转换字节时间" + getByteTime()+" ms")
                .append(",")
                .append("反序列化时间" + getUnSerialTime()+" ms")
                .append(",")
                .append("总耗时" + serialAndUnserial()+" ms")
                .append("]")
                .toString();
    }
}
