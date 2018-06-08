package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.EditProfileDto;
import ru.itis.models.City;
import ru.itis.models.PropertyOwner;
import ru.itis.models.User;
import ru.itis.repositories.CityRepository;
import ru.itis.repositories.PropertyOwnerRepository;
import ru.itis.repositories.UserRepository;

@Service
public class OwnerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    public void edit(EditProfileDto editProfileDto, Long id) {
        User user = userRepository.findById(id);
        PropertyOwner owner = user.getOwner();
        user.setFirstName(editProfileDto.getFirstName());
        user.setSecondName(editProfileDto.getSecondName());
        user.setLastName(editProfileDto.getLastName());
        City city = cityRepository.findById(Long.parseLong(editProfileDto.getCity()));
        owner.setCity(city);
        userRepository.save(user);
        propertyOwnerRepository.save(owner);
    }
}
