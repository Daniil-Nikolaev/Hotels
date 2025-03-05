package by.gpsolutions.hotels.service.histogramStrategy;

import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class BaseHistogramStrategy implements HistogramStrategy {
    @Autowired
    HotelRepository hotelRepository;
}


@Component("histogramBrand")
class HistogramByBrandStrategy extends BaseHistogramStrategy {
    @Override
    public Map<String, Integer> getHistogram() {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> map = new HashMap<>();
        for (Hotel hotel : hotels) {
            String brand = hotel.getBrand();
            map.put(brand, map.getOrDefault(brand, 0) + 1);
        }
        return map;
    }
}


@Component("histogramCity")
class HistogramByCityStrategy extends BaseHistogramStrategy {
    @Override
    public Map<String, Integer> getHistogram() {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> map = new HashMap<>();
        for (Hotel hotel : hotels) {
            String city= hotel.getAddress().getCity();
            map.put(city, map.getOrDefault(city, 0) + 1);
        }
        return map;
    }
}

@Component("histogramCountry")
class HistogramByCountryStrategy extends BaseHistogramStrategy {
    @Override
    public Map<String, Integer> getHistogram() {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> map = new HashMap<>();
        for (Hotel hotel : hotels) {
            String country= hotel.getAddress().getCountry();
            map.put(country, map.getOrDefault(country, 0) + 1);
        }
        return map;
    }
}

@Component("histogramAmenities")
class HistogramByAmenitiesStrategy extends BaseHistogramStrategy {
    @Override
    public Map<String, Integer> getHistogram() {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> map = new HashMap<>();
        for (Hotel hotel : hotels) {
            for (String amenity : hotel.getAmenities()) {
                map.put(amenity,map.getOrDefault(amenity, 0) + 1);
            }
        }
        return map;
    }
}