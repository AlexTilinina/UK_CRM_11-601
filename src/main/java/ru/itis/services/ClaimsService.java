package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.ClaimDto;
import ru.itis.models.Claim;
import ru.itis.models.PropertyOwner;
import ru.itis.models.State;
import ru.itis.repositories.ClaimRepository;

import java.util.Date;
import java.util.List;

@Service
public class ClaimsService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAllClaims(PropertyOwner owner) {
        return claimRepository.findAllByPropertyOwner(owner);
    }

    public void add(ClaimDto claimDto, PropertyOwner propertyOwner) {
        Claim claim = Claim.builder()
                .title(claimDto.getTitle())
                .description(claimDto.getDescription())
                .state(State.NEW)
                .date(new Date())
                .propertyOwner(propertyOwner)
                .build();
        claimRepository.save(claim);
    }

    public List<Claim> getAllByFilter(String filter, PropertyOwner owner) {
        return claimRepository.findAllByPropertyOwnerAndState(owner, getState(filter));
    }

    private State getState(String state) {
        if (state.equals(State.NEW.toString())) {
            return State.NEW;
        }
        else if (state.equals(State.IN_PROCESS.toString())){
            return State.IN_PROCESS;
        }
        else if (state.equals(State.FEEDBACK.toString())){
            return State.FEEDBACK;
        }
        else
            return State.CLOSED;
    }
}
