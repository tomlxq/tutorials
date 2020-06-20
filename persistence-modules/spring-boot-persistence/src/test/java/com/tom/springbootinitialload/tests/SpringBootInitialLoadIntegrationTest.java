package com.tom.springbootinitialload.tests;

import com.tom.boot.Application;
import com.tom.boot.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Sql({"/employees_schema.sql", "/import_employees.sql"})
public class SpringBootInitialLoadIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testLoadDataForTestClass() {
        assertEquals(3, employeeRepository.findAll()
                .size());
    }

    @Test
    @Sql(scripts = {"/import_senior_employees.sql"}, config = @SqlConfig(encoding = "utf-8", transactionMode = TransactionMode.ISOLATED))
    public void testLoadDataForTestCase() {
        assertEquals(5, employeeRepository.findAll()
                .size());
    }
}
