package com.tom.model;

import com.tom.customvalidator.ContactNumberConstraint;

public class ValidatedPhone {

    @ContactNumberConstraint
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone;
    }
}
