package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.PropertyType;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

    PropertyType findByType(String type);

    PropertyType findById(Long id);
}
