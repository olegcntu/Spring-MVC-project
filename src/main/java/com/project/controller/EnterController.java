package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EnterController {


    @GetMapping("/enter")
    public String index(Model model) {

        return "authorizationPages/enter-page";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        return "authorizationPages/registration-page";
    }

    @PostMapping("/registration")
    public String registration(Model model, @RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("psw") String psw,
                               @RequestParam("pswRepeat") String pswRepeat) {
        System.out.println(email);
        System.out.println(name);
        System.out.println(psw);
        System.out.println(pswRepeat);

        return "authorizationPages/registration-page";
    }

    @GetMapping("/renewal")
    public String renewal(Model model) {

        return "authorizationPages/password-reset-page";
    }
}
