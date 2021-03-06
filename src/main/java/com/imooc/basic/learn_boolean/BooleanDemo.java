package com.imooc.basic.learn_boolean;

import org.apache.commons.lang3.BooleanUtils;

public class BooleanDemo {

    public static void main(String[] args) {
        and(new boolean[]{true, true, true});
    }

    private static boolean and(boolean... booleans) {

        for (boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private static boolean and(Boolean... booleans) {
        System.out.println("boolean");
        for (Boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
