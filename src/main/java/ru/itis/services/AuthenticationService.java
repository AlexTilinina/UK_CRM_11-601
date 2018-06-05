package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.details.UserDetailsImpl;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User currentUser = userDetails.getUser();
        Long userId = currentUser.getId();
        return userRepository.findById(userId);
    }
}
