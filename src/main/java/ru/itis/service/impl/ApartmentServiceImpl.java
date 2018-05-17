package ru.itis.service.impl;

import org.springframework.stereotype.Service;
import ru.itis.model.Apartment;
import ru.itis.repository.ApartmentRepository;
import ru.itis.service.ApartmentService;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public void addNewApartment(int number, boolean gas, boolean water, boolean electricity) {
        Apartment apartment = Apartment.builder().number(number).gas(gas)
                .water(water).electricity(electricity).build();
        apartmentRepository.save(apartment);
    }

    @Override
    public void addNewApartment(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @Override
    public Apartment getApartmentById(Long id) {
        return apartmentRepository.getOne(id);
    }

    @Override
    public void updateApartment(Apartment apartment) {
        apartmentRepository.delete(apartment.getId());
        apartmentRepository.save(apartment);
    }

    @Override
    public void deleteApartmentById(Long id) {
        apartmentRepository.delete(id);
    }

    @Override
    public void deleteApartment(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }
}