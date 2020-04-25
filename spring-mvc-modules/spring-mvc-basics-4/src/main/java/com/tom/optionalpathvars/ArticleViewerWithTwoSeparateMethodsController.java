package com.tom.optionalpathvars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tom.optionalpathvars.Article.DEFAULT_ARTICLE;

@RestController
@RequestMapping(value = "/seperateMethods")
public class ArticleViewerWithTwoSeparateMethodsController {

    @RequestMapping(value = "/article/{id}")
    public Article getArticle(@PathVariable(name = "id") Integer articleId) {

        return new Article(articleId);
    }

    @RequestMapping(value = "/article")
    public Article getDefaultArticle() {

        return DEFAULT_ARTICLE;
    }

}