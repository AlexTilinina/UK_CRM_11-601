package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.ServiceType;
import ru.itis.repositories.ServiceTypeRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> getAllServices(){
        return serviceTypeRepository.findAll();
    }

    public void add(String service) {
        ServiceType serviceType = ServiceType.builder()
                .type(service)
                .bills(new HashSet<>())
                .meters(new HashSet<>())
                .build();
        serviceTypeRepository.save(serviceType);
    }
}
