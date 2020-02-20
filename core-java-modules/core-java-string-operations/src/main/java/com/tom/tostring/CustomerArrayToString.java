package com.tom.tostring;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */@Getter
@Setter
public class CustomerArrayToString  extends Customer {
    private Order[] orders;

    @Override
    public String toString() {
        return "Customer [orders=" + Arrays.toString(orders)
                + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName() + "]";
    }
}
