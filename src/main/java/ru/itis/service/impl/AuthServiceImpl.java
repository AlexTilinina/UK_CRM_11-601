package ru.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.config.secuirity.UserDetailsImpl;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currUserDetails = (UserDetailsImpl) authentication.getPrincipal();
        User currUser = currUserDetails.getUser();
        Long currUserId = currUser.getId();
        return userRepository.findOne(currUserId);
    }
}
