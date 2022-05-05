package com.project.controller;

import com.project.dao.ArticleDAO;
import com.project.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public String articleAdd(Principal principal, @RequestParam String title, @RequestParam String topic,
                             @RequestParam String all_txt, Model model) {
        ArticleEntity article = new ArticleEntity(title, topic, all_txt);

       // System.out.println(principal.getName()); имя пользователя, который делает действие

        articleDAO.add(article);
        return "workPages/to-main-page";
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

    @GetMapping("/article/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", articleDAO.showArticle(id));
        return "workPages/edit-page";
    }


    @PatchMapping("/result/{id}")
    public String edit(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("topic")
            String topic, @RequestParam("text") String text, Model model) {

        articleDAO.update(id, name, topic, text);
        return "workPages/to-main-page";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        articleDAO.delete(id);
        return "workPages/to-main-page";
    }
}
