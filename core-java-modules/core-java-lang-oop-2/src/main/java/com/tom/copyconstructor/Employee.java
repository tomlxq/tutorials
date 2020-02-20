package com.tom.copyconstructor;

import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class Employee {

    protected int id;
    protected String name;
    protected Date startDate;

    public Employee(int id, String name, Date startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.startDate = new Date(employee.startDate.getTime());
    }

    Date getStartDate() {
        return startDate;
    }

    public Employee copy() {
        return new Employee(this);
    }
}
