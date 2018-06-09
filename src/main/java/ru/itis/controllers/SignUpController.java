package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.dto.EmployeeRegistration;
import ru.itis.dto.UserRegistration;
import ru.itis.services.*;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CityService cityService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/sign-up")
    public String getSignup(Authentication authentication, @ModelAttribute("model") ModelMap model){
        model.addAttribute("cities", cityService.getAllCities());
        return "signup";
    }

    @PostMapping("sign-up")
    public String signUp(@Valid @ModelAttribute("user")UserRegistration userRegistration, BindingResult errors, RedirectAttributes attributes) {
        registrationService.register(userRegistration);
        return "redirect:/sign-in";
    }

    @GetMapping("admin/sign-up")
    public String getEmployeeSignup(Authentication authentication, @ModelAttribute("model")ModelMap model){
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee-signup";
    }

    @PostMapping("admin/sign-up")
    public String employeeSignUp(@Valid @ModelAttribute("employee")EmployeeRegistration employeeRegistration, BindingResult errors, RedirectAttributes attributes) {
        employeeService.register(employeeRegistration);
        return "redirect:/sign-in";
    }
}
