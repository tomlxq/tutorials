package com.tom.java_8_features;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String name;

    private Address address;


    public User(String name) {
        this.name = name;
    }

    public static boolean isRealUser(User user) {
        return true;
    }


    public boolean isLegalName(String name) {
        return name.length() > 3 && name.length() < 16;
    }
}
