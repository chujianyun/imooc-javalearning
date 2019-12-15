package com.imooc.basic.learn_exit;

import java.io.IOException;

public class ExitTest {
    public static void main(String[] args) {
        // 修改 SecurityManager
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
                if(status ==2){
                    throw new SecurityException("不允许退出");
                }
            }
        });

        try {
            throw new IOException("IO异常了");
        } catch (IOException e) {
            System.exit(2);
        } finally {
            System.out.println("Exiting the program");
        }
    }
}
