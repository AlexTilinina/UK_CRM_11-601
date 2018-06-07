package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.PropertyDto;
import ru.itis.models.*;
import ru.itis.repositories.CityRepository;
import ru.itis.repositories.PropertyRepository;
import ru.itis.repositories.PropertyTypeRepository;
import ru.itis.repositories.StreetRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    public void addProperty(PropertyDto propertyDto, User user) {

        City city = cityRepository.findById(Long.parseLong(propertyDto.getCity()));

        Street street = streetRepository.findByName(propertyDto.getStreet());

        PropertyType propertyType = propertyTypeRepository.findById(Long.parseLong(propertyDto.getType()));

        Property property = Property.builder()
                .city(city)
                .street(street)
                .houseNumber(propertyDto.getHouseNumber())
                .type(propertyType)
                .buildingNumber(propertyDto.getBuildingNumber())
                .flatNumber(propertyDto.getFlatNumber())
                .bills(new HashSet<>())
                .meters(new HashSet<>())
                .owners(new HashSet<>())
                .build();

        Set<PropertyOwner> ownerSet = property.getOwners();
        ownerSet.add(user.getOwner());
        property.setOwners(ownerSet);

        Set<Property> properties = propertyType.getProperties();
        properties.add(property);

        propertyRepository.save(property);
        propertyTypeRepository.save(propertyType);
    }
}
