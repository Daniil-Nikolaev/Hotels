package by.gpsolutions.hotels.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;

}