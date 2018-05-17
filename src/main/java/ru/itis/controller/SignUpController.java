package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.form.FormUser;
import ru.itis.service.AuthService;
import ru.itis.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/basic-user")
    public String getPageLoginStudent(ModelMap model){
        return "signup-basic";
    }

    @PostMapping(value = "/basic-user")
    public String signUp(@Valid FormUser user, BindingResult result, Model model) {
        userService.register(user);
        return "success-reg";
    }
}
