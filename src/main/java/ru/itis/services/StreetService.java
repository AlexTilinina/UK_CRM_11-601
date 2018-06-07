package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.StreetDto;
import ru.itis.models.City;
import ru.itis.models.Street;
import ru.itis.repositories.CityRepository;
import ru.itis.repositories.StreetRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Street> getAllStreets(){
        return streetRepository.findAll();
    }

    @Transactional
    public void add(StreetDto streetDto) {
        City city = cityRepository.findById(Long.parseLong(streetDto.getCity()));

        Street street = Street.builder()
                .name(streetDto.getStreet())
                .properties(new HashSet<>())
                .build();

        Set<Street> streets = city.getStreets();
        streets.add(street);
        city.setStreets(streets);

        street.setCity(city);

        streetRepository.save(street);
        cityRepository.save(city);
    }

    public List<String> getAllStreetsByCity(Long city) {
        City c = cityRepository.findById(city);
        List<Street> streets = streetRepository.findAllByCity(c);
        List<String> names = new ArrayList<>();
        for (Street street : streets) {
            names.add(street.getName());
        }
        return names;
    }
}

