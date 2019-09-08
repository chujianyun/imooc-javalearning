package com.imooc.basic.guard;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class SalaryStrategyEnumTest {

    @Test
    public void getSalary() {
        SalaryStrategyEnum salaryStrategyEnum = SalaryStrategyEnum.valueOf(0);
        if(salaryStrategyEnum != null){
            log.info("角色：{}-->{} 元",salaryStrategyEnum.name(),salaryStrategyEnum.getSalary());
        }
    }
}