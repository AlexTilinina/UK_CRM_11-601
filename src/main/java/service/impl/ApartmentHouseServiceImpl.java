package service.impl;

import model.ApartmentsHouse;
import repository.ApartmentHouseRepository;
import service.ApartmentsHouseService;

import java.util.List;

public class ApartmentHouseServiceImpl implements ApartmentsHouseService {

    private ApartmentHouseRepository apartmentHouseRepository;

    public ApartmentHouseServiceImpl(ApartmentHouseRepository apartmentHouseRepository) {
        this.apartmentHouseRepository = apartmentHouseRepository;
    }

    @Override
    public void addNewApartmentsHouse(String city, String street, int number, boolean garbageRemoval,
                                      boolean yardman, boolean concierge, boolean wetCleaning) {
        ApartmentsHouse apartmentsHouse = ApartmentsHouse.builder().city(city).street(street)
                .number(number).garbageRemoval(garbageRemoval).yardman(yardman)
                .concierge(concierge).wetCleaning(wetCleaning).build();
        apartmentHouseRepository.save(apartmentsHouse);
    }

    @Override
    public void addNewApartmentsHouse(ApartmentsHouse apartmentsHouse) {
        apartmentHouseRepository.save(apartmentsHouse);
    }

    @Override
    public List<ApartmentsHouse> getAllApartmentsHouses() {
        return apartmentHouseRepository.findAll();
    }

    @Override
    public ApartmentsHouse getApartmentsHousesById(Long id) {
        return apartmentHouseRepository.getOne(id);
    }

    @Override
    public void updateApartmentsHouse(ApartmentsHouse apartmentsHouse) {
        apartmentHouseRepository.delete(apartmentsHouse.getId());
        apartmentHouseRepository.save(apartmentsHouse);
    }

    @Override
    public void deleteApartmentsHouseById(Long id) {
        apartmentHouseRepository.delete(id);
    }

    @Override
    public void deleteApartmentsHouse(ApartmentsHouse apartmentsHouse) {
        apartmentHouseRepository.delete(apartmentsHouse);
    }
}
