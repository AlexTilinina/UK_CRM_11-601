package ru.itis.aspects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

    private final static Logger logger = LogManager.getLogger(LogAspect.class);

    @Before("execution(* ru.itis.controllers.AdminController.getSetting(..))")
    private void loggingAdminSettings(JoinPoint jp){
        logger.info("Admin settings: data loaded.");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) && execution(* ru.itis.controllers.AdminController.*(..))")
    private void loggingAdminAdd(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        String data = methodName.replace("add".subSequence(0,3), "");
        logger.info("Admin settings: " + data + " added.");
    }

    @Before("execution(* ru.itis.controllers.BillController.getBills(..))")
    private void loggingGetBills(JoinPoint jp){
        logger.info("Loading bills.");
    }

    @Before("execution(* ru.itis.controllers.BillController.getAddBills(..))")
    private void loggingAddBill(JoinPoint jp){
        logger.info("Adding new bill.");
    }

    @Before("execution(* ru.itis.controllers.BillController.addBills(..))")
    private void loggingAddedBill(JoinPoint jp){
        logger.info("Bill added.");
    }

    @Before("execution(* ru.itis.controllers.ClaimController.getClaims(..))")
    private void loggingGetClaims(JoinPoint jp){
        logger.info("Loading claims.");
    }

    @Before("execution(* ru.itis.controllers.ClaimController.saveClaim(..))")
    private void loggingAddClaim(JoinPoint jp){
        logger.info("Claim added.");
    }

    @Before("execution(* ru.itis.controllers.ClaimController.addAnswer(..))")
    private void loggingAnswerClaims(JoinPoint jp){
        logger.info("Answered claim.");
    }

    @Before("execution(* ru.itis.controllers.MainPageController.getNews(..))")
    private void loggingLoadingNews(JoinPoint jp){
        logger.info("Loading news.");
    }

    @Before("execution(* ru.itis.controllers.MainPageController.getViewNews(..))")
    private void loggingLoadingNewsById(JoinPoint jp){
        logger.info("Loading news with id = " + jp.getArgs()[2].toString() + ".");
    }

    @Before("execution(* ru.itis.controllers.MainPageController.addNews(..))")
    private void loggingAddNews(JoinPoint jp){
        logger.info("Added news.");
    }

    @Before("execution(* ru.itis.controllers.MainPageController.sendEditNews(..))")
    private void loggingEditNews(JoinPoint jp){
        logger.info("Article with id = " + jp.getArgs()[0].toString() + " edited.");
    }

    @Before("execution(* ru.itis.controllers.MainPageController.deleteNews(..))")
    private void loggingDeleteNews(JoinPoint jp){
        logger.info("Article with id = " + jp.getArgs()[2].toString() + " deleted.");
    }

    @Before("execution(* ru.itis.controllers.MeterController.getMeter(..))")
    private void loggingGetMeters(JoinPoint jp){
        logger.info("Loading meters.");
    }

    @Before("execution(* ru.itis.controllers.MeterController.addMeter(..))")
    private void loggingAddMeter(JoinPoint jp){
        logger.info("Meter added.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.getProfile(..))")
    private void loggingGetProfile(JoinPoint jp){
        logger.info("Loading profile.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.editProfile(..))")
    private void loggingEditProfile(JoinPoint jp){
        logger.info("Profile edited.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.getProfileProperty(..))")
    private void loggingGetProperty(JoinPoint jp){
        logger.info("Loading profile property.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.addProperty(..))")
    private void loggingAddProperty(JoinPoint jp){
        logger.info("Added new property.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.editProperty(..))")
    private void loggingEditProperty(JoinPoint jp){
        logger.info("Property (id: " + jp.getArgs()[0].toString() + ") edited.");
    }

    @Before("execution(* ru.itis.controllers.ProfileController.deleteProperty(..))")
    private void loggingDeleteProperty(JoinPoint jp){
        logger.info("Property (id: " + jp.getArgs()[2].toString() + ") deleted.");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) && execution(* ru.itis.controllers.SignUpController.*(..))")
    private void loggingUserRegistered(JoinPoint jp){
        logger.info("New user registered.");
    }
}
