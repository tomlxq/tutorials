package com.tom.streams;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class Product {

    private int price;

    private String name;

    private boolean utilize;

    public Product(int price, String name) {
        this(price);
        this.name = name;
    }

    public Product(int price) {
        this.price = price;
    }


    public static Stream<String> streamOf(List<String> list) {
        return (list == null || list.isEmpty()) ? Stream.empty() : list.stream();
    }
}