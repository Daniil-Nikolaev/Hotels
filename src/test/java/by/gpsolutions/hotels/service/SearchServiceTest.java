package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.service.searchStrategy.SearchStrategy;
import by.gpsolutions.hotels.service.searchStrategy.SearchStrategyFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    SearchStrategyFactory searchStrategyFactory;

    @Mock
    SearchStrategy searchStrategy;

    @InjectMocks
    SearchService searchService;

    @Test
    void searchSuccess() {
        String param="city";
        String value="Minsk";
        HotelResponseDto hotelResponseDto=new HotelResponseDto(1,"name","description","address","phone");
        List<HotelResponseDto> expected=List.of(hotelResponseDto);

        when(searchStrategyFactory.getStrategy(param)).thenReturn(searchStrategy);
        when(searchStrategy.search(value)).thenReturn(expected);


        List<HotelResponseDto> actual = searchService.search(param, value);


        assertEquals(expected, actual);
        verify(searchStrategyFactory, times(1)).getStrategy(param);
        verify(searchStrategy, times(1)).search(value);
    }
}