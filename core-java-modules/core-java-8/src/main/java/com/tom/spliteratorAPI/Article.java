package com.tom.spliteratorAPI;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private List<Author> listOfAuthors;
    private int id;
    private String name;

    public Article(String name) {
        this.name = name;
    }

    public Article(List<Author> listOfAuthors, int id) {
        super();
        this.listOfAuthors = listOfAuthors;
        this.id = id;
    }
}