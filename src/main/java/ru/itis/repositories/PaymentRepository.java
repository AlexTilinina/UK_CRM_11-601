package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Payment;
import ru.itis.models.PropertyOwner;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByPropertyOwner(PropertyOwner propertyOwner);
}
