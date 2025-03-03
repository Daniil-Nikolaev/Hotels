package by.gpsolutions.hotels.service;

import by.gpsolutions.hotels.dto.HotelCreateDto;
import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Hotel;
import by.gpsolutions.hotels.repository.HotelRepository;
import by.gpsolutions.hotels.utils.HotelUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelUtils hotelUtils;

    public HotelService(HotelRepository hotelRepository, HotelUtils hotelUtils) {
        this.hotelRepository = hotelRepository;
        this.hotelUtils = hotelUtils;
    }


    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();
        List<HotelResponseDto> allHotelDtos = new ArrayList<>();

        for (Hotel hotel : allHotels) {
            allHotelDtos.add(hotelUtils.convertHotelToHotelResponseDto(hotel));
        }
        return allHotelDtos;
    }

    public Optional<Hotel> getHotelById(int id) {
       return hotelRepository.findById(id);
    }

    public HotelResponseDto saveHotel(HotelCreateDto hotelCreateDto) {
        Hotel created=new Hotel();

        created.setName(hotelCreateDto.getName());
        created.setDescription(hotelCreateDto.getDescription());
        created.setBrand(hotelCreateDto.getBrand());
        created.setAddress(hotelCreateDto.getAddress());
        created.setContacts(hotelCreateDto.getContacts());
        created.setArrivalTime(hotelCreateDto.getArrivalTime());

        hotelRepository.save(created);
        return hotelUtils.convertHotelToHotelResponseDto(created);

    }

    public void addAmenities(int id,List<String> amenities){
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isPresent()){
            hotel.get().getAmenities().addAll(amenities);
            hotelRepository.save(hotel.get());
        }else{
            throw new IllegalArgumentException("Hotel with ID " + id + " not found");
        }
    }
}