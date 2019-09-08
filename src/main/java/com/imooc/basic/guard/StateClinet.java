package com.imooc.basic.guard;

public class StateClinet {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tomcat");

        Context context = new Context();
        context.setStudent(student);

        // 报名状态
        context.setCurrentState(new EnrollState());
        context.doAction();

        // 学习状态
        State nextSate = context.getNextSate();
        while (nextSate != null) {
            context.setCurrentState(nextSate);
            nextSate.doAction();
            nextSate = nextSate.nextState;
        }
    }
}
