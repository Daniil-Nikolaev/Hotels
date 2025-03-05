package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.service.histogramStrategy.HistogramStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HistogramService {

    private final HistogramStrategyFactory histogramStrategyFactory;

    public HistogramService(HistogramStrategyFactory histogramStrategyFactory) {
        this.histogramStrategyFactory = histogramStrategyFactory;
    }

    public Map<String,Integer> getHistogram(String param){
        return histogramStrategyFactory.getStrategy(param).getHistogram();
    }
}
