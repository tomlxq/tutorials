package com.tom.javaxval.enums;

import com.tom.javaxval.enums.constraints.CustomerTypeSubset;
import com.tom.javaxval.enums.demo.Customer;
import com.tom.javaxval.enums.demo.CustomerType;
import com.tom.javaxval.enums.demo.CustomerUnitTest;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class CustomerTypeSubSetValidatorUnitTest {

    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Test
    public void whenEnumAnyOfSubset_thenShouldNotReportConstraintViolations() {
        Customer customer = new Customer.Builder().withCustomerTypeOfSubset(CustomerType.NEW)
                .build();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.isEmpty()).isTrue();
    }
    @Test
    public void whenEnumNotAnyOfSubset_thenShouldGiveOccurrenceOfConstraintViolations() {
        Customer customer = new Customer.Builder().withCustomerTypeOfSubset(CustomerType.DEFAULT)
                .build();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(1);

        assertThat(violations).anyMatch(CustomerUnitTest.havingPropertyPath("customerTypeOfSubset")
                .and(CustomerUnitTest.havingMessage("must be any of [NEW, OLD]")));
    }
}