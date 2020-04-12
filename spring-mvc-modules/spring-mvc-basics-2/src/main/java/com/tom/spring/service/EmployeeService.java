package com.tom.spring.service;

import com.tom.spring.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getEmployeeList();
}
