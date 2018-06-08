package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.EditProfileDto;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public void edit(EditProfileDto editProfileDto, Long id) {
        User user = userRepository.findById(id);
        user.setFirstName(editProfileDto.getFirstName());
        user.setSecondName(editProfileDto.getSecondName());
        user.setLastName(editProfileDto.getLastName());
        userRepository.save(user);
    }
}
