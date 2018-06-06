package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.UserRegistration;
import ru.itis.models.City;
import ru.itis.models.PropertyOwner;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.CityRepository;
import ru.itis.repositories.PropertyOwnerRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PropertyOwnerRepository ownerRepository;

    @Transactional
    public void register(UserRegistration userRegistration) {
        User user = User.builder()
                .firstName(userRegistration.getFirstName())
                .secondName(userRegistration.getSecondName())
                .lastName(userRegistration.getLastName())
                .email(userRegistration.getEmail())
                .role(Role.USER)
                .login(userRegistration.getLogin())
                .password(passwordEncoder.encode(userRegistration.getPassword()))
                .build();

        PropertyOwner owner = PropertyOwner.builder()
                .user(user)
                .claims(new HashSet<>())
                .meters(new HashSet<>())
                .payments(new HashSet<>())
                .properties(new HashSet<>())
                .build();

        City city = findCity(userRegistration.getCity());
        setOwners(city, owner);

        owner.setCity(city);
        user.setOwner(owner);

        cityRepository.save(city);
        ownerRepository.save(owner);
    }

    @Transactional
    protected City findCity(String name) {
        return cityRepository.findCityByName(name);
    }

    private void setOwners(City city, PropertyOwner owner) {
        Set<PropertyOwner> owners = city.getOwners();
        owners.add(owner);
        city.setOwners(owners);
    }
}
