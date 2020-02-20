/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
package com.tom.javaxval.enums;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tom.javaxval.enums.constraints.CustomerTypeSubset;
import com.tom.javaxval.enums.demo.CustomerType;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, CustomerType> {
    private CustomerType[] subset;

    @Override
    public void initialize(CustomerTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(CustomerType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset)
                .contains(value);
    }
}
