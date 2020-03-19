package com.tom.multipledb.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private int id;

    private String name;

    private double price;


    public static Product from(int id, String name, double price) {
        return new Product(id, name, price);
    }


}