package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
