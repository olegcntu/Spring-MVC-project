package com.project.controller;

import com.project.config.SpringConfig;
import com.project.dao.ArticleDAO;
import com.project.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workPage")
public class WorkController {

    @Autowired
    private ArticleDAO articleDAO;

    @GetMapping("/mainPage")
    public String mainPage(Model model) {
        model.addAttribute("article", articleDAO.index());
        return "workPages/main-page";
    }


    @GetMapping("/add")
    public String articleAddForm(Model model) {

        return "workPages/article-add-page";
    }

    @PostMapping("/add")
    public String articleAdd(@RequestParam String title, @RequestParam String topic,
                             @RequestParam String all_txt, Model model) {
        Article article = new Article(title, topic, all_txt);
        articleDAO.add(article);
        return "workPages/article-add-page";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {

        return "workPages/about-page";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", articleDAO.showArticle(id));
        return "workPages/article-page";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        return "workPages/all-authors-page";
    }
}
