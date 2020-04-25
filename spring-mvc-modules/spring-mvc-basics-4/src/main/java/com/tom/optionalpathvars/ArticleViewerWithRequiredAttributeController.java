package com.tom.optionalpathvars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tom.optionalpathvars.Article.DEFAULT_ARTICLE;

;

@RestController
@RequestMapping(value = "/requiredAttribute")
public class ArticleViewerWithRequiredAttributeController {

    @RequestMapping(value = {"/article", "/article/{id}"})
    public Article getArticle(@PathVariable(name = "id", required = false) Integer articleId) {

        if (articleId != null) {
            return new Article(articleId);
        } else {
            return DEFAULT_ARTICLE;
        }

    }

}