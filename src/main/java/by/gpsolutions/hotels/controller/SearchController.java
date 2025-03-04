package by.gpsolutions.hotels.controller;

import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.service.SearchService;
import by.gpsolutions.hotels.utils.SearchUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property-view")
public class SearchController {
    private final SearchService searchService;
    private final SearchUtils searchUtils;

    public SearchController(SearchService searchService, SearchUtils searchUtils) {
        this.searchService = searchService;
        this.searchUtils = searchUtils;
    }

    @GetMapping("/search")
    public ResponseEntity<List<HotelResponseDto>> searchHotels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String amenities) {

        String param =searchUtils.getParam(name, brand, city, country, amenities);
        List<HotelResponseDto> result;

        switch (param) {
            case "name":
                result=searchService.search("name",name);
                break;
            case "brand":
                result=searchService.search("brand",brand);
                break;
            case "city":
                result=searchService.search("city",city);
                break;
            case "country":
                result=searchService.search("country",country);
                break;
            case "amenities":
                result=searchService.search("amenities",amenities);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        if(result.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);

    }
}
