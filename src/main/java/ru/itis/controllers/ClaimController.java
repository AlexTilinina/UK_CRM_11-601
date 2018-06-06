package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dto.ClaimDto;
import ru.itis.models.Claim;
import ru.itis.models.PropertyOwner;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;
import ru.itis.services.ClaimsService;

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
        PropertyOwner propertyOwner = user.getOwner();
        List<Claim> claims = claimsService.getAllClaims(propertyOwner);
        if (!claims.isEmpty()){
            model.addAttribute("claims", claims);
        }
        return "claims";
    }

    @GetMapping("/claims/add")
    public String getAddClaim(){
        return "add-claim";
    }

    @PostMapping("/claims/add")
    public String saveClaim(Authentication authentication, @ModelAttribute("claim")ClaimDto claimDto){
        User user = authenticationService.getUserByAuthentication(authentication);
        PropertyOwner propertyOwner = user.getOwner();
        claimsService.add(claimDto, propertyOwner);
        return "redirect:/claims";
    }

    @PostMapping("/claims/filter")
    public String filterClaims(Authentication authentication, @ModelAttribute("filter") String filter,
                               @ModelAttribute("model") ModelMap model){
        User user = authenticationService.getUserByAuthentication(authentication);
        PropertyOwner propertyOwner = user.getOwner();
        List<Claim> claims = claimsService.getAllByFilter(filter, propertyOwner);
        if (!claims.isEmpty()){
            model.addAttribute("claims", claims);
        }
        return "claims";
    }
}
