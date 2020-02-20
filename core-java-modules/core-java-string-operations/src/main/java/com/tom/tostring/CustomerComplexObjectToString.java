package com.tom.tostring;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
@Getter
@Setter
public class CustomerComplexObjectToString extends Customer {
    private Order order;
    //standard setters and getters

    @Override
    public String toString() {
        return "Customer [order=" + order + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName() + "]";
    }
}
