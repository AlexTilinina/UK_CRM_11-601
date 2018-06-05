package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.City;
import ru.itis.models.User;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    City findCityByName(String name);
}
