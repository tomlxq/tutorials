package com.tom.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Foo extends AbstractEntity {

    private String name;

    public Foo(long id) {
        super(id);
        name = randomAlphanumeric(4);
    }

    public Foo(long id, String name) {
        super(id);
        this.name = name;
    }
}
