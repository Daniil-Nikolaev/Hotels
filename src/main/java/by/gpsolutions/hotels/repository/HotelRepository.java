package by.gpsolutions.hotels.repository;

import by.gpsolutions.hotels.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Override
    Optional<Hotel> findById(Integer id);
    List<Hotel> findByName(String name);
    List<Hotel> findByBrand(String brand);
    List<Hotel> findByAddressCity(String city);
    List<Hotel> findByAddressCountry(String country);
    List<Hotel> findByAmenities(String amenity);
}
