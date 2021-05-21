package com.tasnim.aast;
import java.util.UUID;

public abstract class Donor {
    private String street;
    private String city;
    private String stateName;
    private String phone;
    private String email;
    private String userName;
    private String password;
    private boolean isAdmin;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }


    public Donor( String street, String city, String stateName, String phone, String email, String userName, String password, boolean isAdmin) {
        this.street = street;
        this.city = city;
        this.stateName = stateName;
        this.phone = phone;
        this.email = email;
        this.userName=userName;
        this.password= password;
        this.isAdmin=isAdmin;
    }

    public String getCity() {
        return city;
    }

    public String getStateName() {
        return stateName;
    }

    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }

// abstract method called donorIdentity return data type String
//    Doesn't have implementation in the donor class but has implementation in the child class ( organization and individual)
// return the name of the donor based on the type of the donor either individual or organization

// overriding same method toString used in superclass (Donor) and the child class ( organization and individual)

    @Override
    public String toString() {
        return "\nDonor{" +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", stateName='" + stateName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
