package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
