package com.tom.collections.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable {

    private String name;
    private int age;
    private double salary;

    @Override
    public boolean equals(Object obj) {
        return ((Employee) obj).getName()
                .equals(getName());
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        return getName().compareTo(e.getName());
    }
}