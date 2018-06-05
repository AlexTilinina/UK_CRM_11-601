package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
