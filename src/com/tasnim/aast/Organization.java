package com.tasnim.aast;

public class Organization extends  Donor {

    private  String organizationName;
    private  String firstNameContact;
    private  String lastNameContact;
    private  String description;

    public Organization(String organizationName) {
        this.organizationName = organizationName;
    }

    public Organization(String organizationName, String firstNameContact, String lastNameContact, String description) {
        this.organizationName = organizationName;
        this.firstNameContact = firstNameContact;
        this.lastNameContact = lastNameContact;
        this.description = description;
    }

    public Organization(String street, String city, String stateName, String phone, String email, String organizationName, String firstNameContact, String lastNameContact, String description) {
        super(street, city, stateName, phone, email);
        this.organizationName = organizationName;
        this.firstNameContact = firstNameContact;
        this.lastNameContact = lastNameContact;
        this.description = description;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getFirstNameContact() {
        return firstNameContact;
    }

    public void setFirstNameContact(String firstNameContact) {
        this.firstNameContact = firstNameContact;
    }

    public String getLastNameContact() {
        return lastNameContact;
    }

    public void setLastNameContact(String lastNameContact) {
        this.lastNameContact = lastNameContact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String donorIdentity() {
        return this.organizationName +" "+ this.getDonorID();
    }

    @Override
    public String toString() {
        return super.toString()+"Organization{" +
                "organizationName='" + organizationName + '\'' +
                ", firstNameContact='" + firstNameContact + '\'' +
                ", lastNameContact='" + lastNameContact + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
