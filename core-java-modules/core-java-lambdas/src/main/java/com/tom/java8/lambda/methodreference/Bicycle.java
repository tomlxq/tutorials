package com.tom.java8.lambda.methodreference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    public Bicycle(String brand, Integer frameSize) {
        this.brand = brand;
        this.frameSize = frameSize;
    }


}