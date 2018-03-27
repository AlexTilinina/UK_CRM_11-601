package repository;

import model.ApartmentsHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentHouseRepository extends JpaRepository<ApartmentsHouse, Long> {
}
