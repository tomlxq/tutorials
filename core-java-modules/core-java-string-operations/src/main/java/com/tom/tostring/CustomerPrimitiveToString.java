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
public class CustomerPrimitiveToString extends Customer {
    private long balance;

    @Override
    public String toString() {
        return "Customer [balance=" + balance + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName() + "]";
    }
}
