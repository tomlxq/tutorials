package com.tom.streams;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Detail {

    private static final List<String> PARTS = Arrays.asList("turbine", "pump");

    public List<String> getParts() {
        return PARTS;
    }
}