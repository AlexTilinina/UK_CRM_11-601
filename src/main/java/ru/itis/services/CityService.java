package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.City;
import ru.itis.repositories.CityRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public void add(String name){
        City city = City.builder()
                .name(name)
                .owners(new HashSet<>())
                .properties(new HashSet<>())
                .streets(new HashSet<>())
                .build();
        cityRepository.save(city);
    }
}
