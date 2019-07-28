package com.imooc.basic.nullpoint;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderUpdateParam implements Serializable {
    private static final long serialVersionUID = 3240762365557530541L;

    private Long id;

    private String name;

    // 其他属性

    @NonNull
    private String extra;
}
