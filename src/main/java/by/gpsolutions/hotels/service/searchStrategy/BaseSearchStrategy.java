package by.gpsolutions.hotels.service.searchStrategy;

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


@Component("searchName")
class SearchByNameStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByName(paramValue);
        return convertToDtoList(hotels);
    }
}


@Component("searchBrand")
class SearchByBrandStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByBrand(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("searchCity")
class SearchByCityStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAddressCity(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("searchCountry")
class SearchByCountryStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAddressCountry(paramValue);
        return convertToDtoList(hotels);
    }
}

@Component("searchAmenities")
class SearchByAmenityStrategy extends BaseSearchStrategy {
    @Override
    public List<HotelResponseDto> search(String paramValue) {
        List<Hotel> hotels = hotelRepository.findByAmenities(paramValue);
        return convertToDtoList(hotels);
    }
}