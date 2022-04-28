package com.project.controller;

import com.project.dao.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workPage")
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authors", authorDAO.index());
        return "workPages/all-authors-page";
    }

    @GetMapping("/authors/{id}")
    public String author(@PathVariable("id") int id, Model model) {
        model.addAttribute("authors", authorDAO.index());
        return "workPages/author-page";
    }

}
