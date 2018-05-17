package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.model.User;
import ru.itis.service.AuthService;
import ru.itis.service.UserService;
import ru.itis.utils.Role;

@Controller
public class ProfileController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, @ModelAttribute("model") ModelMap model) throws Exception {
        if (authentication != null){
            User user = authService.getUserByAuthentication(authentication);
            model.addAttribute("user", user);
            return "profile";
        }
        return "redirect:/sign-in";
    }

    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication != null) {
            User user = authService.getUserByAuthentication(authentication);
            if (user.getRole().equals(Role.BASIC_USER)) {
                return "redirect:/profile";
            }
            else if (user.getRole().equals(Role.ADVANCED_USER)){
                return "redirect:/profile";
            }
        }
        return "redirect:/sign-in";
    }
}
