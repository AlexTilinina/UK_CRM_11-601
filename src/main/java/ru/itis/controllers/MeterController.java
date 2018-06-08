package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.MeterDto;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;
import ru.itis.services.MeterService;
import ru.itis.services.ServiceTypeService;

@Controller
public class MeterController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MeterService meterService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/meters")
    public String getMeter(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        if (user.getRole().equals(Role.USER)) {
            model.addAttribute("meters", meterService.getAllMeters(user));
        }
        else {
            model.addAttribute("meters", meterService.getAllMeters());
        }
        model.addAttribute("user", user);
        return "meters";
    }

    @GetMapping("/meters/add/{service}")
    public String getAddMeterGas(Authentication authentication, @ModelAttribute("model") ModelMap model,
                                 @PathVariable("service") String service) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("properties", user.getOwner().getProperties());
        model.addAttribute("service", serviceTypeService.getService(service));
        return "add-meter";
    }


    @PostMapping("/meters/add")
    public String addMeter(Authentication authentication, @ModelAttribute("model") ModelMap model,
                          @ModelAttribute("payment") MeterDto meterDto) {
        User user = authenticationService.getUserByAuthentication(authentication);
        model.addAttribute("role", user.getRole().toString());
        meterService.add(meterDto, user);
        return "redirect:/meters";
    }
}
