package com.springRest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHomePage(Model model) {
        return "Home/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

