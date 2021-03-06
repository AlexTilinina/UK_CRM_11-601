package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

    ServiceType findById(Long id);

    ServiceType findByType(String type);
}
