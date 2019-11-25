package com.imooc.basic.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadLogDemo {

    public static void main(String[] args) {

        Exception e = new RuntimeException("错了");

        //log.info("错误信息为={}", e);
        Result result = null;

       /* if (result == null || result.getData() == null) {
            log.info("result={},resultData:{}", result, result.getData());
        }*/

       log.info( "a", "b");

       e.printStackTrace();

    }
}
