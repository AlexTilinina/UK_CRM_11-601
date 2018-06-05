package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
