package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
