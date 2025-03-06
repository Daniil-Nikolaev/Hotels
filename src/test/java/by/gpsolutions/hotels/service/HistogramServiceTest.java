package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.service.histogramStrategy.HistogramStrategy;
import by.gpsolutions.hotels.service.histogramStrategy.HistogramStrategyFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistogramServiceTest {

    @Mock
    HistogramStrategyFactory histogramStrategyFactory;

    @Mock
    HistogramStrategy histogramStrategy;

    @InjectMocks
    HistogramService histogramService;

    @Test
    void getHistogramSuccess() {
        String param="city";
        Map<String,Integer> expected=new HashMap<>();
        expected.put("Minsk",1);

        when(histogramStrategyFactory.getStrategy(param)).thenReturn(histogramStrategy);
        when(histogramStrategy.getHistogram()).thenReturn(expected);

        Map<String, Integer> actual = histogramService.getHistogram(param);

        assertEquals(expected,actual);
        verify(histogramStrategyFactory,times(1)).getStrategy(param);
        verify(histogramStrategy,times(1)).getHistogram();
    }
}