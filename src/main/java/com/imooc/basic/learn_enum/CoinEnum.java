package com.imooc.basic.learn_enum;

import lombok.Getter;

public enum CoinEnum {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25)/*,NEWONE(50)*/;

    CoinEnum(int value) {
        this.value = value;
    }

    @Getter
    private final int value;

    public int value() {
        return value;
    }


    private static CoinEnum[] $VALUES2;

    static {
        $VALUES2 = new CoinEnum[4];
        $VALUES2[0] = PENNY;
        $VALUES2[1] = NICKEL;
        $VALUES2[2] = DIME;
        $VALUES2[3] = QUARTER;
    }



    public static CoinEnum getByValue(int value) {
        CoinEnum[] values = CoinEnum.values();
        values[0] = CoinEnum.QUARTER;

        //CoinEnum some = PENNY;
        for (CoinEnum coinEnum : CoinEnum.values()) {
            if (coinEnum.value == value) {
                return coinEnum;
            }
        }
        return null;
    }
}
