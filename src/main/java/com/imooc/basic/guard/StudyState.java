package com.imooc.basic.guard;

/**
 * 学习状态
 */
public class StudyState extends State {

    public StudyState() {
        nextState = new GraduateState();
    }

    @Override
    void doAction() {
        System.out.println(String.format("学生%s正在学习....", context.getStudent().getName()));
    }
}
