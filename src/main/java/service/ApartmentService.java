package service;

import model.Apartment;

import java.util.List;

public interface ApartmentService {

    void addNewApartment(int number, boolean gas, boolean water, boolean electricity);

    void addNewApartment(Apartment apartment);

    List<Apartment> getAllApartments();

    Apartment getApartmentById(Long id);

    void updateApartment(Apartment apartment);

    void deleteApartmentById(Long id);

    void deleteApartment(Apartment apartment);
}
