package com.imooc.basic.guard;

public class IfElseDemo {
    public static void main(String[] args) {

    }

    /**
     * 根据职位获取薪资
     */
    public double getSalaryGuard(Integer position) {

        if (position == null) {
            throw new IllegalArgumentException("职位不能为空");
        }
        // 老板
        if (isBoss(position)) {
            return getBossSalary();
        }
        // 领导
        if (isLeader(position)) {
            return getLeaderSalary();
        }
        // 普通员工
        return getStaffSalary();
    }


    /**
     * 根据职位获取薪资
     */
    public double getSalary(Integer position) {

        double result;
        if (position == null) {
            throw new IllegalArgumentException("职位不能为空");
        }

        // 老板
        if (isBoss(position)) {
            result = getBossSalary();
        } else {
            // 领导
            if (isLeader(position)) {
                result = getLeaderSalary();
            } else {
                // 普通员工
                result = getStaffSalary();
            }
        }
        return result;
    }

    private double getStaffSalary() {
        return 10000;
    }


    private double getLeaderSalary() {
        return 50000;
    }

    private double getBossSalary() {
        return 100000D;
    }

    private boolean isStaff(Integer position) {
        return 2 == position;
    }

    private boolean isLeader(Integer position) {

        return 1 == position;
    }

    private boolean isBoss(Integer position) {
        return 0 == position;
    }
}
