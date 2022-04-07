package com.project.controller;

import com.project.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String articleAdd(Model model) {

        return "workPages/article-add-page";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {

        return "workPages/about-page";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {

        return "workPages/all-authors-page";
    }
}
