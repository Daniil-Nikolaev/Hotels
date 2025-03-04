package by.gpsolutions.hotels.service.strategy;

import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.repository.HotelRepository;
import by.gpsolutions.hotels.utils.HotelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseSearchStrategy implements SearchStrategy {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelUtils hotelUtils;

    protected List<HotelResponseDto> convertToDtoList(List<Hotel> hotels) {
        List<HotelResponseDto> list=new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelResponseDto hotelResponseDto=hotelUtils.convertHotelToHotelResponseDto(hotel);
            list.add(hotelResponseDto);
        }
        return list;
    }
}


@Component("name")
class SearchByNameStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByName(paramValue);
        return convertToDtoList(hotels);
    }
}


@Component("brand")
class SearchByBrandStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByBrand(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("city")
class SearchByCityStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAddressCity(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("country")
class SearchByCountryStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAddressCountry(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("amenities")
class SearchByAmenityStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAmenities(paramValue);
        return convertToDtoList(hotels);
    }
}