package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {

    @GetMapping("/sign-in")
    public String getMain(@ModelAttribute("model")ModelMap model) {
        return "signin";
    }
}
