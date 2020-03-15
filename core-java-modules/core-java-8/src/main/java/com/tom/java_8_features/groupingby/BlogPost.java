package com.tom.java_8_features.groupingby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BlogPost {
    private String title;
    private String author;
    private BlogPostType type;
    private int likes;
}