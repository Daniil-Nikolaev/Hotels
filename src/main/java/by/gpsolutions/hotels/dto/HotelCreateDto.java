package by.gpsolutions.hotels.dto;

import by.gpsolutions.hotels.entity.Address;
import by.gpsolutions.hotels.entity.ArrivalTime;
import by.gpsolutions.hotels.entity.Contacts;


public class HotelCreateDto {
    private String name;
    private String description;
    private String brand;
    private Address address;
    private Contacts contacts;
    private ArrivalTime arrivalTime;

    public HotelCreateDto(String name, String description, String brand, Address address, Contacts contacts, ArrivalTime arrivalTime) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.address = address;
        this.contacts = contacts;
        this.arrivalTime = arrivalTime;
    }

    public HotelCreateDto() {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public Address getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
