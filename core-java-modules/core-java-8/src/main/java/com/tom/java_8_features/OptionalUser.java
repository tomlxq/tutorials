package com.tom.java_8_features;


import lombok.Setter;

import java.util.Optional;

@Setter
public class OptionalUser {

    private OptionalAddress address;

    public Optional<OptionalAddress> getAddress() {
        return Optional.of(address);
    }
}
