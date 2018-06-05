package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.PropertyOwner;

public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {
}
