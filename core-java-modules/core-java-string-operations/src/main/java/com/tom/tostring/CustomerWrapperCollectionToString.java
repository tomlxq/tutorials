package com.tom.tostring;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */@Getter
@Setter
public class CustomerWrapperCollectionToString extends Customer {
    private Integer score; // Wrapper class object
    private List<String> orders; // Collection object
    private StringBuffer fullname; // StringBuffer object

    @Override
    public String toString() {
        return "Customer [score=" + score + ", orders=" + orders + ", fullname=" + fullname
                + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
    }
}
