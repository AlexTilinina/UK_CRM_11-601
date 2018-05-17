package ru.itis.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.model.User;

@Service
public interface AuthService {
    User getUserByAuthentication(Authentication authentication);
}
