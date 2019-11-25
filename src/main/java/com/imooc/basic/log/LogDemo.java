package com.imooc.basic.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDemo {

    public void first() {
        log.debug("慕课专栏");
    }

    public void second(String website) {
        StringBuilder builder = new StringBuilder();
        builder.append("慕课网");
        builder.append(website);
        String result = builder.toString();
        log.debug(result);
    }

    public void third(String website) {
        if (!log.isDebugEnabled()) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("慕课网");
        builder.append(website);
        String result = builder.toString();
        log.debug(result);
    }
}
