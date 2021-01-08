package com.tasnim.aast;
import java.util.UUID;

public abstract class Donor {
    private String donorID;
    private String street;
    private String city;
    private String stateName;
    private String phone;
    private String email;

    public Donor() {
        this.donorID = UUID.randomUUID().toString(); ;
    }

    public Donor(String street, String city, String stateName, String phone, String email) {
        this();
        this.street = street;
        this.city = city;
        this.stateName = stateName;
        this.phone = phone;
        this.email = email;
    }

    public String getDonorID() {
        return donorID;
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

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

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

    public  abstract String donorIdentity();

    @Override
    public String toString() {
        return "Donor{" +
                "donorID='" + donorID + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", stateName='" + stateName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
