package ru.itis.config.secuirity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    //менять здесь
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    //менять здесь
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("Пользователь с таким логином  <" + login + "> уже существует"));
        return new UserDetailsImpl(user);
    }

}
