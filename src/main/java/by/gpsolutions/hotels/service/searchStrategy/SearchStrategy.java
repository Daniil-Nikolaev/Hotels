package by.gpsolutions.hotels.service.searchStrategy;

import by.gpsolutions.hotels.dto.HotelResponseDto;

import java.util.List;

public interface SearchStrategy {
     List<HotelResponseDto> search(String param);
}
