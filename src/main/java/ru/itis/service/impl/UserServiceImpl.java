package ru.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.form.FormUser;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.service.UserService;
import ru.itis.utils.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void register(FormUser userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(Role.BASIC_USER)
                .build();

        userRepository.save(user);
    }

    @Override
    public void addNewUser(String login, String password, Role role, String name, String surname, String city, String phoneNumber) {
        User user = User.builder().login(login).password(password).role(role).name(name)
                .surname(surname).city(city).phoneNumber(phoneNumber).build();
        userRepository.save(user);
    }

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.delete(user.getId());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
