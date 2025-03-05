package by.gpsolutions.hotels.service.searchStrategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SearchStrategyFactory {

    private final Map<String, SearchStrategy> strategies;


    public SearchStrategyFactory(Map<String, SearchStrategy> strategies) {
        this.strategies = strategies;
    }

    public SearchStrategy getStrategy(String param) {
    return switch (param) {
        case "name" -> strategies.get("searchName");
        case "brand" -> strategies.get("searchBrand");
        case "city" -> strategies.get("searchCity");
        case "country" -> strategies.get("searchCountry");
        case "amenities" -> strategies.get("searchAmenities");
        default -> throw new IllegalArgumentException("No strategy for: " + param);
    };
    }
}