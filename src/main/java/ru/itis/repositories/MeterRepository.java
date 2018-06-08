package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Meter;
import ru.itis.models.PropertyOwner;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {

    List<Meter> findAllByPropertyOwner(PropertyOwner propertyOwner);
}
