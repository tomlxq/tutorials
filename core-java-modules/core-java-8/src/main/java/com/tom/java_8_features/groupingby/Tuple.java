package com.tom.java_8_features.groupingby;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public class Tuple {
    private final BlogPostType type;
    private final String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return type == tuple.type && author.equals(tuple.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, author);
    }
}