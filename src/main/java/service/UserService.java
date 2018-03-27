package service;

import model.User;

import java.util.List;

public interface UserService {

    void addNewUser(String login, String password, String role,
                    String name, String surname, String city, String phoneNumber);

    void addNewUser(User user);

    List<User> getAllUsers();
}
