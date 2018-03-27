package service.impl;

import model.User;
import repository.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public void addNewUser(String login, String password, String role, String name, String surname, String city, String phoneNumber) {
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
