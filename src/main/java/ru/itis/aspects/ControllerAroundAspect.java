package ru.itis.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;

@Aspect
@Configuration
public class ControllerAroundAspect {

    @Autowired
    private AuthenticationService authenticationService;

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object setUserRole(ProceedingJoinPoint jp) throws Throwable {
        Authentication authentication = (Authentication) jp.getArgs()[0];
        ModelMap model = (ModelMap) jp.getArgs()[1];
        if (authentication != null){
            User user = authenticationService.getUserByAuthentication(authentication);
            model.addAttribute("role", user.getRole().toString());
        }
        return jp.proceed();
    }
}
