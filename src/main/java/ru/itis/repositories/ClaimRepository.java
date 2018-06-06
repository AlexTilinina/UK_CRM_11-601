package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Claim;
import ru.itis.models.PropertyOwner;
import ru.itis.models.State;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findAllByPropertyOwner(PropertyOwner propertyOwner);

    List<Claim> findAllByPropertyOwnerAndState(PropertyOwner propertyOwner, State state);
}
