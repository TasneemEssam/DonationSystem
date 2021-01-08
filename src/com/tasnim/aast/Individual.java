package com.tasnim.aast;

public class Individual  extends  Donor{
    private String firstName;
    private String lastName;


    public Individual(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Individual(String street, String city, String stateName, String phone, String email, String firstName, String lastName) {
        super(street, city, stateName, phone, email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String donorIdentity() {
        return this.firstName +" "+ this.lastName +" "+ this.getDonorID();
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Individual{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
