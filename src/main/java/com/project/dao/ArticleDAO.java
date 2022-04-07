package com.project.dao;

import com.project.models.Article;
import com.project.models.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ArticleDAO {
    private static int ARTICLE_ID = 0;
    private List<Article> articles = new ArrayList<>();

    {
        articles.add(new Article(1, "problem with kv-1C", "tenk problem", new Author("Krasavin"), 5, new Date()));
        articles.add(new Article(2, "problem with kv-1C", "tenk problem", new Author("Krasavin"), 5, new Date()));
        articles.add(new Article(3, "problem with kv-1C", "tenk problem", new Author("Krasavin"), 5, new Date()));
        articles.add(new Article(4, "problem with kv-1C", "tenk problem", new Author("Krasavin"), 5, new Date()));
    }

    public List<Article> index() {
        return articles;
    }

}
