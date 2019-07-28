package com.imooc.basic.nullpoint;

public class OperationDemo {

    public void doSomeOperation(Operation operation) {
        int a = 5;
        int b = 6;
        operation.execute(a, b);
    }
}
