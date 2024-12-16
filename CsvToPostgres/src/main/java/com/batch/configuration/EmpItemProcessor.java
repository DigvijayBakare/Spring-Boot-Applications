package com.batch.configuration;

import com.batch.entities.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmpItemProcessor implements ItemProcessor<Employee, Employee> {
    @Override
    public Employee process(Employee emp) throws Exception {
//        System.out.println("Processing: " +emp);
        return emp;
    }
}
