package com.imooc.basic.learn_enum;

import com.imooc.basic.util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public enum DateEnum {

    /**
     * 日期类型
     */
    DAY(1) {
        @Override
        String getDateString(LocalDate localDate) {
            return DateUtil.SIMPLE_FORMATTER.format(localDate);
        }
    },
    WEEK(2) {
        @Override
        String getDateString(LocalDate localDate) {
            return DateUtil.SIMPLE_FORMATTER.format(localDate.with(DayOfWeek.MONDAY));
        }
    },
    MOUNTH(3) {
        @Override
        String getDateString(LocalDate localDate) {
            return DateUtil.SIMPLE_FORMATTER.format(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        }
    };

    private int type;

    abstract String getDateString(LocalDate localDate);

    DateEnum(int type) {
        this.type = type;
    }
}
