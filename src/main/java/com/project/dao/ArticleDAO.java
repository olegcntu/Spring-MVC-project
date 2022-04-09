package com.project.dao;

import com.project.models.Article;
import com.project.models.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ArticleDAO {
    public static int ARTICLE_ID = 0;
    private List<Article> articles = new ArrayList<>();

    {
        articles.add(new Article( "problem with kv-1C", "tenk problem", "qwer"));
        articles.add(new Article( "problem with kv-1C", "tenk problem", "qwer"));
        articles.add(new Article( "problem with kv-1C", "tenk problem", "qwer"));
        articles.add(new Article( "problem with kv-1C", "tenk problem", "qwer"));
    }

    public List<Article> index() {
        return articles;
    }

    public void add(Article article){
        articles.add(article);
    }

    public Article showArticle(int id){
        return articles.stream().filter(articles->articles.getId()==id).findAny().orElse(null);
    }
}
