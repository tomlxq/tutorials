package com.tom.tostring;

import lombok.Data;
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
public class Customer {
    private String firstName;
    private String lastName;
    // standard getters and setters. No toString() implementation
}
