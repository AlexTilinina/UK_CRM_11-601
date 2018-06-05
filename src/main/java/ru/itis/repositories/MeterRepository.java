package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Meter;

public interface MeterRepository extends JpaRepository<Meter, Long> {
}
