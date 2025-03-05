package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.service.searchStrategy.SearchStrategy;
import by.gpsolutions.hotels.service.searchStrategy.SearchStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchStrategyFactory searchStrategyFactory;

    public SearchService(SearchStrategyFactory searchStrategyFactory) {
        this.searchStrategyFactory = searchStrategyFactory;
    }


    public List<HotelResponseDto> search(String param,String value) {
        SearchStrategy strategy = searchStrategyFactory.getStrategy(param);
        return strategy.search(value);
    }

    


}
