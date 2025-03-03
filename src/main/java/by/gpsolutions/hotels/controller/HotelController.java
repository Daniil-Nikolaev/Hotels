package by.gpsolutions.hotels.controller;


import by.gpsolutions.hotels.dto.HotelCreateDto;
import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.service.HotelService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/property-view")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public List<HotelResponseDto> getAll() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable int id) {
     Optional<Hotel> hotel = hotelService.getHotelById(id);
     if (hotel.isEmpty()) {
         return ResponseEntity.notFound().build();
     }
     return ResponseEntity.ok(hotel.get());
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelResponseDto>createHotel(@RequestBody HotelCreateDto hotel) {
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @PostMapping("/hotels/{id}/amenities")
    public void addAmenities(@PathVariable int id,@RequestBody List<String> amenities){
        hotelService.addAmenities(id, amenities);
    }
}
