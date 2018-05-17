package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.ApartmentsHouse;

public interface ApartmentHouseRepository extends JpaRepository<ApartmentsHouse, Long> {


}
