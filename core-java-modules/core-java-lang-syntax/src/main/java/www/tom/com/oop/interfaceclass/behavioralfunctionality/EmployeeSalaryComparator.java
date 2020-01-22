package www.tom.com.oop.interfaceclass.behavioralfunctionality;

import java.util.Comparator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employeeA, Employee employeeB) {
        if (employeeA.getSalary() < employeeB.getSalary()) {
            return -1;
        } else if (employeeA.getSalary() > employeeB.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }
}