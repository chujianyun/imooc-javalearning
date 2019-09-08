package com.imooc.basic.guard;

/**
 * 毕业状态
 */
public class GraduateState extends State {

    public GraduateState() {
        nextState = null;
    }

    @Override
    void doAction() {
        System.out.println(String.format("学生%s毕业了....", context.getStudent().getName()));
    }
}
