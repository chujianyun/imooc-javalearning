package com.imooc.basic.guard;

public class StateSimple {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tomcat");

    }

    private void doAction(Integer state, Student student) {

        if (state == null) {
            throw new IllegalArgumentException("状态不能为空");
        }

        switch (state) {
            case 0:
                enroll(student);
                break;
            case 1:
                study(student);
                break;

            case 2:
                graduate(student);
                break;
            default:
        }
    }

    /**
     * 入学
     */
    private void enroll(Student student) {
        System.out.println(String.format("学生%s报名中....", student.getName()));
    }

    /**
     * 学习
     */
    private void study(Student student) {
        System.out.println(String.format("学生%s正在学习....", student.getName()));
    }

    /**
     * 毕业
     */
    private void graduate(Student student) {
        System.out.println(String.format("学生%s毕业了....", student.getName()));
    }


}
