package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.NewsDto;
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
        if (pageable.getPageSize() == 20){
            pageable = new PageRequest(0, 6);
        }
        Page<News> news = newsService.getNews(pageable);
        boolean stop = false;
        if (news.getSize() != 6 || news.hasNext()) {
            stop = true;
        }
        model.addAttribute("news", news.getContent());
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("stop", stop);
        return "news";

    }
    @GetMapping("/news/{id}")
    public String getViewNews(@PathVariable("id") Long id, @ModelAttribute("model") ModelMap model){
        News news = newsService.getFullNews(id);
        model.addAttribute("news", news);
        return "view-news";
    }

    @GetMapping("/news/add")
    public String getViewNews() {
        return "add-news";
    }

    @PostMapping("/news/add")
    public String addNews(@ModelAttribute("user")NewsDto newsDto) {
        newsService.add(newsDto);
        return "redirect:/news";
    }

    @GetMapping("news/edit/{id}")
    public String editNews(@ModelAttribute("model")ModelMap model, @PathVariable("id")Long id){
        News news = newsService.getFullNews(id);
        model.addAttribute("news", news);
        return "edit-news";
    }

    @PostMapping("news/edit/{id}")
    public String sendEditNews(@PathVariable("id") Long id, @ModelAttribute("user")NewsDto newsDto) {
        newsService.edit(newsDto, id);
        return "redirect:/news";
    }
    @GetMapping("/api/news/delete/{id}")
    public String deleteNews(@PathVariable("id") Long id) {
        newsService.delete(id);
        return "redirect:/news";
    }
}
