package by.gpsolutions.hotels.controller;


import by.gpsolutions.hotels.dto.HotelCreateDto;
import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/property-view")
@Tag(name="Hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ApiResponse(responseCode = "200",description = "ok")
    @ApiResponse(responseCode = "404",description = "no result")
    @Operation(summary = "Find all Hotels")
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelResponseDto>> getAll() {
        List<HotelResponseDto> all=hotelService.getAllHotels();
        if(all.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(all);
    }

    @ApiResponse(responseCode = "200",description = "ok")
    @ApiResponse(responseCode = "404",description = "no result")
    @Operation(summary = "Find Hotel by id")
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable int id) {
     Optional<Hotel> hotel = hotelService.getHotelById(id);
     if (hotel.isEmpty()) {
         return ResponseEntity.notFound().build();
     }
     return ResponseEntity.ok(hotel.get());
    }

    @ApiResponse(responseCode = "200",description = "ok")
    @Operation(summary = "Create Hotel")
    @PostMapping("/hotels")
    public ResponseEntity<HotelResponseDto>createHotel(@RequestBody HotelCreateDto hotel) {
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @ApiResponse(responseCode = "200",description = "ok")
    @ApiResponse(responseCode = "404",description = "hotel not found")
    @Operation(summary = "Add amenities in Hotel")
    @PostMapping("/hotels/{id}/amenities")
    public ResponseEntity<?> addAmenities(@PathVariable int id,@RequestBody List<String> amenities){
        if(hotelService.addAmenities(id, amenities).getStatusCode().is4xxClientError()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
