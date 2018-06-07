package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.PropertyType;
import ru.itis.repositories.PropertyTypeRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class PropertyTypeService {

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    public List<PropertyType> getAllPropertyTypes(){
        return propertyTypeRepository.findAll();
    }

    public void add(String type) {
        PropertyType propertyType = PropertyType.builder()
                .type(type)
                .properties(new HashSet<>())
                .build();
        propertyTypeRepository.save(propertyType);
    }
}
