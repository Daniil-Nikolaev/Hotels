package by.gpsolutions.hotels.utils;

import by.gpsolutions.hotels.dto.HotelResponseDto;
import by.gpsolutions.hotels.entity.Address;
import by.gpsolutions.hotels.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelUtils {

    public HotelResponseDto convertHotelToHotelResponseDto(Hotel hotel) {
        HotelResponseDto hotelResponseDto = new HotelResponseDto();

        hotelResponseDto.setId(hotel.getId());
        hotelResponseDto.setName(hotel.getName());
        hotelResponseDto.setDescription(hotel.getDescription());
        hotelResponseDto.setAddress(formatAddress(hotel.getAddress()));
        hotelResponseDto.setPhone(hotel.getContacts().getPhone());

        return hotelResponseDto;
    }

    public String formatAddress(Address address) {
        return String.format("%s %s, %s, %s, %s",
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getPostCode(),
                address.getCountry());
    }
}
