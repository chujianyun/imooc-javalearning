package com.imooc.basic.learn_test;

import lombok.Data;

@Data
public class PdfData {

    private Integer id;

    private String name;

    private String waterMark;

    private Integer pages;

    // 其他属性

    private PdfAttribute pdfAttribute;
}
