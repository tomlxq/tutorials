package com.tom.java_8_features;


import lombok.Setter;

import java.util.Optional;

@Setter
public class OptionalAddress {

    private String street;

    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }
}