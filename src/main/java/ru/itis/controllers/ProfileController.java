package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.EditProfileDto;
import ru.itis.dto.PropertyDto;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.services.*;

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

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PositionService positionService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, @ModelAttribute("model")ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("user", user);
//        model.addAttribute("role", user.getRole().toString());
        return "profile";
    }

    @GetMapping("/profile/edit/{id}")
    public String getEditProfile(Authentication authentication, @ModelAttribute("model")ModelMap model, @PathVariable Long id) {
        User user = authenticationService.getUserById(id);
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("user", user);
        model.addAttribute("types", propertyTypeService.getAllPropertyTypes());
//        model.addAttribute("role", user.getRole().toString());
        model.addAttribute("positions", positionService.getAllPositions());
        return "edit-profile";
    }

    @PostMapping("/profile/edit/{id}")
    public String editProfile(Authentication authentication, @PathVariable Long id, @ModelAttribute("user")EditProfileDto editProfileDto) {
        User user = authenticationService.getUserByAuthentication(authentication);
        if (user.getRole().equals(Role.USER)) {
            ownerService.edit(editProfileDto, id);
        }
        else if (user.getRole().equals(Role.EMPLOYEE)) {
            employeeService.edit(editProfileDto, id);
        }
        else {
            adminService.edit(editProfileDto, id);
        }
        return "redirect:/profile";
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
//        model.addAttribute("role", user.getRole().toString());
        return "property";
    }

    @PostMapping("/property/add")
    public String addProperty(Authentication authentication, @ModelAttribute("property") PropertyDto propertyDto) {
        User user = authenticationService.getUserByAuthentication(authentication);
        propertyService.addProperty(propertyDto, user);
        return "redirect:/property";
    }

    @GetMapping("/property/edit/{id}")
    public String getEditProperty(Authentication authentication, @ModelAttribute("model") ModelMap model, @PathVariable Long id) {
        model.addAttribute("property", propertyService.getPropertyById(id));
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("types", propertyTypeService.getAllPropertyTypes());
        User user = authenticationService.getUserByAuthentication(authentication);
//        model.addAttribute("role", user.getRole().toString());
        return "edit-property";
    }

    @PostMapping("/property/edit/{id}")
    public String editProperty(@PathVariable Long id, @ModelAttribute("property") PropertyDto propertyDto) {
        propertyService.edit(propertyDto, id);
        return "redirect:/property";
    }

    @GetMapping("/property/delete/{id}")
    public String deleteNews(Authentication authentication, @ModelAttribute("model") ModelMap model, @PathVariable("id") Long id) {
        propertyService.delete(id);
        return "redirect:/property";
    }
}
