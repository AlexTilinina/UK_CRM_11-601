package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.PropertyDto;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;
import ru.itis.services.CityService;
import ru.itis.services.PropertyService;
import ru.itis.services.PropertyTypeService;

@Controller
public class ProfileController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyTypeService propertyTypeService;

    @Autowired
    private CityService cityService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, @ModelAttribute("model")ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/property")
    public String getProfileProperty(Authentication authentication, @ModelAttribute("model")ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("types", propertyTypeService.getAllPropertyTypes());
        if (!user.getOwner().getProperties().isEmpty()) {
            model.addAttribute("properties", user.getOwner().getProperties());
        }
        return "property";
    }

    @PostMapping("/property/add")
    public String addProperty(Authentication authentication, @ModelAttribute("property") PropertyDto propertyDto) {
        User user = authenticationService.getUserByAuthentication(authentication);
        propertyService.addProperty(propertyDto, user);
        return "redirect:/property";
    }
}

