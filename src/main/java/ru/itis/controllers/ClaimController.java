package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.ClaimDto;
import ru.itis.models.*;
import ru.itis.services.AuthenticationService;
import ru.itis.services.ClaimsService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClaimController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ClaimsService claimsService;

    @GetMapping("/claims")
    public String getClaims(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        User user = authenticationService.getUserByAuthentication(authentication);
        if (user.getRole().equals(Role.USER)) {
            PropertyOwner propertyOwner = user.getOwner();
            List<Claim> claims = claimsService.getAllClaimsByOwner(propertyOwner);
            if (!claims.isEmpty()) {
                model.addAttribute("claims", claims);
            }
        }
        else if (user.getRole().equals(Role.EMPLOYEE)) {
            Employee employee = user.getEmployee();
            List<Claim> claims = claimsService.getAllClaims();
            if (!claims.isEmpty()) {
                model.addAttribute("claims", claims);
                model.addAttribute("employee", employee);
            }
        }
        return "claims";
    }

    @GetMapping("/claims/add")
    public String getAddClaim(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        return "add-claim";
    }

    @PostMapping("/claims/add")
    public String saveClaim(Authentication authentication, @Valid @ModelAttribute("claim")ClaimDto claimDto,
                            BindingResult buildingResult, @ModelAttribute("model") ModelMap model){
        User user = authenticationService.getUserByAuthentication(authentication);
        if (buildingResult.hasErrors()){
            model.addAttribute("role", user.getRole().toString());
            return "add-claim";
        }
        if (user.getRole().equals(Role.USER)) {
            PropertyOwner propertyOwner = user.getOwner();
            claimsService.add(claimDto, propertyOwner);
        }
        return "redirect:/claims";
    }

    @PostMapping("/claims/filter")
    public String filterClaims(Authentication authentication, @ModelAttribute("filter") String filter,
                               @ModelAttribute("model") ModelMap model){
        User user = authenticationService.getUserByAuthentication(authentication);
        if (user.getRole().equals(Role.USER)) {

            PropertyOwner propertyOwner = user.getOwner();
            List<Claim> claims = claimsService.getAllByFilter(filter, propertyOwner);
            if (!claims.isEmpty()){
                model.addAttribute("claims", claims);
            }
        }
        else if (user.getRole().equals(Role.EMPLOYEE) || user.getRole().equals(Role.ADMIN)) {
            Employee employee = user.getEmployee();
            List<Claim> claims = claimsService.getAllByFilter(filter);
            if (!claims.isEmpty()){
                model.addAttribute("claims", claims);
                model.addAttribute("employee", employee);
            }
        }
        return "claims";
    }

    @PostMapping("/claims/add/answer/{id}")
    public String addAnswer(Authentication authentication, @PathVariable("id") Long id, @ModelAttribute("answer") String answer) {
        User user = authenticationService.getUserByAuthentication(authentication);
        Employee employee = user.getEmployee();
        claimsService.addAnswer(id, answer, employee);
        return "redirect:/claims";
    }

    @PostMapping("/claims/add/state/{id}")
    public String addAnswer(@PathVariable("id") Long id, @ModelAttribute("state") String state) {
        claimsService.setState(id, state);
        return "redirect:/claims";
    }
}
