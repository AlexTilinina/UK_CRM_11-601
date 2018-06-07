package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.City;
import ru.itis.models.Street;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Long> {

    Street findByName(String street);

    Street findById(Long id);
    
    List<Street> findAllByCity(City city);
}
