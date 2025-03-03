package by.gpsolutions.hotels.repository;

import by.gpsolutions.hotels.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Override
    Optional<Hotel> findById(Integer id);
}
