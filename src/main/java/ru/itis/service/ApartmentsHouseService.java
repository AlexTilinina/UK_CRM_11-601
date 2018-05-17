package ru.itis.service;

import ru.itis.model.ApartmentsHouse;

import java.util.List;

public interface ApartmentsHouseService {

    void addNewApartmentsHouse(String city, String street, int number, boolean garbageRemoval,
                               boolean yardman, boolean concierge, boolean wetCleaning);

    void addNewApartmentsHouse(ApartmentsHouse apartmentsHouse);

    List<ApartmentsHouse> getAllApartmentsHouses();

    ApartmentsHouse getApartmentsHousesById(Long id);

    void updateApartmentsHouse(ApartmentsHouse apartmentsHouse);

    void deleteApartmentsHouseById(Long id);

    void deleteApartmentsHouse(ApartmentsHouse apartmentsHouse);
}
