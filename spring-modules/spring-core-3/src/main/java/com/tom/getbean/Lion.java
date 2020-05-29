package com.tom.getbean;

import lombok.Data;

@Data
class Lion implements AnnotationConfig.Animal {
    private String name;

    Lion(String name) {
        this.name = name;
    }
}
