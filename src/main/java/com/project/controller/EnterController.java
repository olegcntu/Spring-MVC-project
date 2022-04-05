package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EnterController {


    @GetMapping("/enter")
    public String index(Model model) {

        return "enterPage/enter";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        return "enterPage/registration";
    }

    @GetMapping("/renewal")
    public String renewal(Model model) {

        return "enterPage/renewal";
    }
}
