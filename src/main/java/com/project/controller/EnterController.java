package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EnterController {


    @GetMapping("/enter")
    public String index(Model model) {

        return "authorizationPages/enterPage";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        return "authorizationPages/registrationPage";
    }

    @GetMapping("/renewal")
    public String renewal(Model model) {

        return "authorizationPages/passwordResetPage";
    }
}
