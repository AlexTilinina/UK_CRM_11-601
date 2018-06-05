package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.models.News;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;
import ru.itis.services.NewsService;

@Controller
public class MainPageController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String getMain(Authentication authentication, @ModelAttribute("model") ModelMap modelMap) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            modelMap.addAttribute("name", user.getSecondName());
        }
        return "main";
    }
    @GetMapping("/news")
    public String getNews(@ModelAttribute("model") ModelMap model, Pageable pageable) {
        Page<News> news = newsService.getNews(pageable);
        boolean stop = false;
        if (news.getSize() != 6 || news.hasNext()) {
            stop = true;
        }
        model.addAttribute("news", news.getContent());
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("stop", stop);
        return "index";
    }

}
