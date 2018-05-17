package ru.itis.service;

import org.springframework.stereotype.Service;
import ru.itis.form.FormUser;
import ru.itis.model.User;
import ru.itis.utils.Role;

import java.util.List;

@Service
public interface UserService {

    void addNewUser(String login, String password, Role role,
                    String name, String surname, String city, String phoneNumber);

    void addNewUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);

    void deleteUser(User user);

    void register(FormUser user);
}
