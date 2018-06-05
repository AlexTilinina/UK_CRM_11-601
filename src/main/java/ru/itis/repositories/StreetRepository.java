package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
