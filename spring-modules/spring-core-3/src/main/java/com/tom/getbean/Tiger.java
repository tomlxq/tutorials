package com.tom.getbean;

import lombok.Data;

@Data
class Tiger implements AnnotationConfig.Animal {
    private String name;

    Tiger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
