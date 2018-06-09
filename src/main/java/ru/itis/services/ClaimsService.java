package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.ClaimDto;
import ru.itis.models.Claim;
import ru.itis.models.Employee;
import ru.itis.models.PropertyOwner;
import ru.itis.models.State;
import ru.itis.repositories.ClaimRepository;

import java.util.Date;
import java.util.List;

@Service
public class ClaimsService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private FileService fileService;

    public List<Claim> getAllClaimsByOwner(PropertyOwner owner) {
        return claimRepository.findAllByPropertyOwner(owner);
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public void add(ClaimDto claimDto, PropertyOwner propertyOwner) {
        fileService.upload(claimDto.getFile());
        String filePath = claimDto.getFile().getOriginalFilename();
        Claim claim = Claim.builder()
                .title(claimDto.getTitle())
                .description(claimDto.getDescription())
                .state(State.NEW)
                .date(new Date())
                .propertyOwner(propertyOwner)
                .filePath(filePath.isEmpty() ? null : filePath)
                .build();
        claimRepository.save(claim);
    }

    public List<Claim> getAllByFilter(String filter, PropertyOwner owner) {
        return claimRepository.findAllByPropertyOwnerAndState(owner, getState(filter));
    }

    public List<Claim> getAllByFilter(String filter) {
        return claimRepository.findAllByState(getState(filter));
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

    public void addAnswer(Long id, String answer, Employee employee) {
        Claim claim = claimRepository.findById(id);
        claim.setAnswer(answer);
        claim.setEmployee(employee);
        claim.setState(State.CLOSED);
        claimRepository.save(claim);
    }

    public void setState(Long id, String state) {
        Claim claim = claimRepository.findById(id);
        claim.setState(getState(state));
        claimRepository.save(claim);
    }
}
