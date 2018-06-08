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

    private final static String ELECTRICITY = "Внести показания электричества";
    private final static String GAS = "Внести показания газа";
    private final static String WATER = "Внести показания воды";

    public List<ServiceType> getAllServices(){
        List<ServiceType> serviceTypeList = serviceTypeRepository.findAll();
        for (int i = 0; i < 3; i++) {
            serviceTypeList.remove(serviceTypeList.get(0));
        }
        return serviceTypeList;
    }

    public void add(String service) {
        ServiceType serviceType = ServiceType.builder()
                .type(service)
                .bills(new HashSet<>())
                .meters(new HashSet<>())
                .build();
        serviceTypeRepository.save(serviceType);
    }

    private ServiceType getElectricity() {
        return serviceTypeRepository.findByType(ELECTRICITY);
    }

    private ServiceType getGas() {
        return serviceTypeRepository.findByType(GAS);
    }

    private ServiceType getWater() {
        return serviceTypeRepository.findByType(WATER);
    }

    public ServiceType getService(String service) {
        switch (service) {
            case "gas":
                return getGas();
            case "electricity":
                return getElectricity();
            default:
                return getWater();
        }
    }
}
