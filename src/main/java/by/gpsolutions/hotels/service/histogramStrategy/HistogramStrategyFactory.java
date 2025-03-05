package by.gpsolutions.hotels.service.histogramStrategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HistogramStrategyFactory {
    private final Map<String, HistogramStrategy> strategies;

    public HistogramStrategyFactory(Map<String, HistogramStrategy> strategies) {
        this.strategies = strategies;
    }


    public HistogramStrategy getStrategy(String param) {
    return switch (param) {
        case "brand" -> strategies.get("histogramBrand");
        case "city" -> strategies.get("histogramCity");
        case "country" -> strategies.get("histogramCountry");
        case "amenities" -> strategies.get("histogramAmenities");
        default -> throw new IllegalArgumentException("No strategy for: " + param);
    };
    }
}
