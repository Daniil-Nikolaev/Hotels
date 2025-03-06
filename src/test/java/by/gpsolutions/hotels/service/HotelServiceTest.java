package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.dto.HotelCreateDto;
import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Address;
import by.gpsolutions.hotels.entity.ArrivalTime;
import by.gpsolutions.hotels.entity.Contacts;
import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.repository.HotelRepository;
import by.gpsolutions.hotels.utils.HotelUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

    @Mock
    HotelRepository hotelRepository;
    @Mock
    HotelUtils hotelUtils;
    @InjectMocks
    HotelService hotelService;


    @Test
    void getAllHotelsSuccess() {
        Hotel hotel = new Hotel();
        hotel.setId(1);
        HotelResponseDto hotelResponseDto = new HotelResponseDto();
        hotelResponseDto.setId(1);

        List<Hotel> hotels = List.of(hotel);

        when(hotelRepository.findAll()).thenReturn(hotels);
        when(hotelUtils.convertHotelToHotelResponseDto(hotel)).thenReturn(hotelResponseDto);

        List<HotelResponseDto> result = hotelService.getAllHotels();


        assertEquals(1, result.size());
        assertEquals(hotelResponseDto, result.get(0));
        verify(hotelRepository, times(1)).findAll();
        verify(hotelUtils, times(1)).convertHotelToHotelResponseDto(hotel);

    }

    @Test
    void getHotelByIdSuccess() {
        Hotel hotel = new Hotel();
        hotel.setId(1);

        when(hotelRepository.findById(hotel.getId())).thenReturn(Optional.of(hotel));

        Optional<Hotel> result = hotelService.getHotelById(hotel.getId());

        assertTrue(result.isPresent());
        assertEquals(hotel, result.get());
        verify(hotelRepository, times(1)).findById(hotel.getId());
    }

    @Test
    void saveHotel() {
        HotelCreateDto hotelCreateDto=new HotelCreateDto();
        Hotel hotel=new Hotel();
        HotelResponseDto hotelResponseDto=new HotelResponseDto();


        when(hotelRepository.save(hotel)).thenReturn(hotel);
        when(hotelUtils.convertHotelToHotelResponseDto(hotel)).thenReturn(hotelResponseDto);


        HotelResponseDto result = hotelService.saveHotel(hotelCreateDto);


        assertNotNull(result);
        assertEquals(hotelResponseDto, result);
        verify(hotelRepository, times(1)).save(hotel);
        verify(hotelUtils, times(1)).convertHotelToHotelResponseDto(hotel);
    }

    @Test
    void addAmenities() {
        Hotel hotel=new Hotel();
        hotel.setId(1);
        hotel.setAmenities(new ArrayList<>());
        List<String> amenities=List.of("Free Wi-fi","Free parking");


        when(hotelRepository.findById(hotel.getId())).thenReturn(Optional.of(hotel));
        when(hotelRepository.save(hotel)).thenReturn(hotel);

        hotelService.addAmenities(hotel.getId(), amenities);

        verify(hotelRepository, times(1)).findById(hotel.getId());
        verify(hotelRepository, times(1)).save(hotel);
        assertEquals(2, hotel.getAmenities().size());
        assertTrue(hotel.getAmenities().containsAll(amenities));
    }
}