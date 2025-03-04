package by.gpsolutions.hotels.service.strategy;

import by.gpsolutions.hotels.dto.HotelResponseDto;

import java.util.List;

public interface SearchStrategy {
     List<HotelResponseDto> search(String param);
}
