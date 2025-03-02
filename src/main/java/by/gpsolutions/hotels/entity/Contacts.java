package by.gpsolutions.hotels.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class Contacts {

    private String phone;
    private String email;

    public Contacts(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public Contacts() {}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}