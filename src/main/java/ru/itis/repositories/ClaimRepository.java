package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Claim;
import ru.itis.models.User;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
