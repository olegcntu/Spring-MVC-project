package com.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EnterController {


    @GetMapping("/enter")
    public String index(Model model) {
        return "enterPage/index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        return "enterPage/registration";
    }

}
