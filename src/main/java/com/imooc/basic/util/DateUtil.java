package com.imooc.basic.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final DateTimeFormatter SIMPLE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String toDateString(LocalDateTime dateTime) {
        return SIMPLE_FORMATTER.format(dateTime);
    }


}
