package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.MeterDto;
import ru.itis.models.Meter;
import ru.itis.models.Property;
import ru.itis.models.ServiceType;
import ru.itis.models.User;
import ru.itis.repositories.MeterRepository;
import ru.itis.repositories.PropertyRepository;
import ru.itis.repositories.ServiceTypeRepository;

import java.util.Date;
import java.util.List;

@Service
public class MeterService {

    @Autowired
    private MeterRepository meterRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public List<Meter> getAllMeters() {
        return meterRepository.findAll();
    }

    public List<Meter> getAllMeters(User user) {
        return meterRepository.findAllByPropertyOwner(user.getOwner());
    }

    public void add(MeterDto meterDto, User user) {
        Property property = propertyRepository.findById(Long.parseLong(meterDto.getPropertyId()));
        ServiceType serviceType = serviceTypeRepository.findById(Long.parseLong(meterDto.getServiceId()));

        Meter meter = Meter.builder()
                .date(new Date())
                .number(meterDto.getNumber())
                .propertyOwner(user.getOwner())
                .property(property)
                .serviceType(serviceType)
                .build();
        meterRepository.save(meter);

    }
}
