package com.tom.map.mergemaps;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Employee implements Comparable<Employee> {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) {
            return false;
        }
        return name.equals(employee.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }


    @Override
    public int compareTo(Employee employee) {
        return (int) (this.id - employee.getId());
    }
}