package by.gpsolutions.hotels.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;

    public Address(String houseNumber, String street, String city, String country, String postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }

    public Address() {}

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}