

package com.tom.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foo implements Serializable {
    private long id;
    private String name;

    public Foo(final String name) {
        super();

        this.name = name;
    }
}
