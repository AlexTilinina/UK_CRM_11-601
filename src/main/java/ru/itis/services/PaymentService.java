package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.PaymentDto;
import ru.itis.models.*;
import ru.itis.repositories.BillRepository;
import ru.itis.repositories.PropertyRepository;
import ru.itis.repositories.ServiceTypeRepository;

import java.util.Date;
import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private BillRepository billRepository;

    public void add(PaymentDto paymentDto, User user) {
        Property property = propertyRepository.findById(Long.parseLong(paymentDto.getPropertyId()));
        ServiceType serviceType = serviceTypeRepository.findById(Long.parseLong(paymentDto.getServiceType()));
        Payment payment = Payment.builder()
                .date(new Date())
                .propertyOwner(user.getOwner())
                .build();
        Bill bill = Bill.builder()
                .property(property)
                .billNumber(Math.abs(new Random().nextInt()))
                .sum(paymentDto.getSum())
                .serviceType(serviceType)
                .payment(payment)
                .build();
        payment.setBill(bill);
        billRepository.save(bill);
    }
}
