package by.gpsolutions.hotels.utils;

import org.springframework.stereotype.Component;

@Component
public class SearchUtils {

    public String getParam(String name, String brand, String city, String country, String amenities) {
        if (name != null) return "name";
        if (brand != null) return "brand";
        if (city != null) return "city";
        if (country != null) return "country";
        if (amenities != null) return "amenities";
        return null;
    }
}
