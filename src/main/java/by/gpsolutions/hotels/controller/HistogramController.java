package by.gpsolutions.hotels.controller;

import by.gpsolutions.hotels.service.HistogramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property-view")
@Tag(name="Histogram")
public class HistogramController {
    private final HistogramService histogramService;

    public HistogramController(HistogramService histogramService) {
        this.histogramService = histogramService;
    }

    @ApiResponse(responseCode = "200",description = "ok")
    @ApiResponse(responseCode = "400",description = "invalid request")
    @Operation(summary = "Get Histogram by param")
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
