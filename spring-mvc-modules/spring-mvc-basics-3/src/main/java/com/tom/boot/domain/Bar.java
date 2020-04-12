package com.tom.boot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Bar extends AbstractEntity {
    private int value;

    public Bar(long id) {
        super(id);
    }

    public Bar(long id, int value) {
        super(id);
        this.value = value;
    }
}
