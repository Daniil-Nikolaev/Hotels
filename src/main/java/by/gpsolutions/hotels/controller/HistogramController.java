package by.gpsolutions.hotels.controller;

import by.gpsolutions.hotels.service.HistogramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property-view")
public class HistogramController {
    private final HistogramService histogramService;

    public HistogramController(HistogramService histogramService) {
        this.histogramService = histogramService;
    }

    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String,Integer>> getHistogram(@PathVariable String param) {
        Map<String,Integer> histogram;

        switch (param) {
            case "brand":
                histogram=histogramService.getHistogram(param);
                break;
            case "city":
                histogram=histogramService.getHistogram(param);
                break;
            case "country":
                histogram=histogramService.getHistogram(param);
                break;
            case "amenities":
                histogram=histogramService.getHistogram(param);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(histogram);
    }
}
