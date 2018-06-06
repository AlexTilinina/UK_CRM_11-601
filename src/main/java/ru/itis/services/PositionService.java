package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Position;
import ru.itis.repositories.PositionRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions(){
        return positionRepository.findAll();
    }

    public void add(String name){
        Position position = Position.builder()
                .name(name)
                .employees(new HashSet<>())
                .build();
        positionRepository.save(position);
    }
}
