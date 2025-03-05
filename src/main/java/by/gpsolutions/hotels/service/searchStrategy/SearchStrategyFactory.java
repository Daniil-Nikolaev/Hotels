package by.gpsolutions.hotels.service.searchStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SearchStrategyFactory {

    private final Map<String, SearchStrategy> strategies;

    @Autowired
    public SearchStrategyFactory(Map<String, SearchStrategy> strategies) {
        this.strategies = strategies;
    }

    public SearchStrategy getStrategy(String paramName) {
        SearchStrategy strategy = strategies.get(paramName);
        return strategy;
    }
}