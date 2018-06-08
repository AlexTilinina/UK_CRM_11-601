package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.PaymentDto;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;
import ru.itis.services.BillService;
import ru.itis.services.PaymentService;
import ru.itis.services.ServiceTypeService;

@Controller
public class BillController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BillService billService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/bills")
    public String getBills(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("role", user.getRole().toString());
        if (user.getRole().equals(Role.USER)) {
            model.addAttribute("bills", billService.getAllBills(user));
        }
        else {
            model.addAttribute("bills", billService.getAllBills());
        }
        return "bills";
    }

    @GetMapping("/payment")
    public String getAddBills(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("role", user.getRole().toString());
        model.addAttribute("properties", user.getOwner().getProperties());
        model.addAttribute("services", serviceTypeService.getAllServices());
        return "add-bills";
    }

    @PostMapping("/payment")
    public String addBills(Authentication authentication, @ModelAttribute("model") ModelMap model,
                           @ModelAttribute("payment") PaymentDto paymentDto) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("role", user.getRole().toString());
        paymentService.add(paymentDto, user);
        return "redirect:/bills";
    }
}
