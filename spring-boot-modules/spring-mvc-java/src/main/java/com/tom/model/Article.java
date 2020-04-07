package com.tom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    public static final Article DEFAULT_ARTICLE = new Article(12);

    private Integer id;



}
