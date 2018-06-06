package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.dto.EmployeeRegistration;
import ru.itis.dto.UserRegistration;
import ru.itis.services.CityService;
import ru.itis.services.EmployeeService;
import ru.itis.services.PositionService;
import ru.itis.services.RegistrationService;

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

    @GetMapping("/sign-up")
    public String getSignup(@ModelAttribute("model")ModelMap model){
        model.addAttribute("cities", cityService.getAllCities());
        return "signup";
    }

    @PostMapping("sign-up")
    public String signUp(@Valid @ModelAttribute("user")UserRegistration userRegistration, BindingResult errors, RedirectAttributes attributes) {
        registrationService.register(userRegistration);
        return "redirect:/sign-in";
    }

    @GetMapping("admin/sign-up")
    public String getEmployeeSignup(@ModelAttribute("model")ModelMap model){
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee-signup.ftl";
    }

    @PostMapping("admin/sign-up")
    public String employeeSignUp(@Valid @ModelAttribute("employee")EmployeeRegistration employeeRegistration, BindingResult errors, RedirectAttributes attributes) {
        employeeService.register(employeeRegistration);
        return "redirect:/sign-in";
    }
}
