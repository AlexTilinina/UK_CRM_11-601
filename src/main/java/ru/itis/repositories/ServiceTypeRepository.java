package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
