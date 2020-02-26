package com.tom.findanelement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {

    private int id;
    private String name;

    @Override
    public int hashCode() {
        return id * 20;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer otherCustomer = (Customer) obj;
            if (id == otherCustomer.id)
                return true;
        }
        return false;
    }
}