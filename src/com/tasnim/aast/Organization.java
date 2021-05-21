package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Organization {

    private  String organizationName;
    private  String firstNameContact;
    private  String lastNameContact;
    private  String description;


    public Organization(String organizationName, Connection connection) {
        String query = " insert into donors (organizationName, type) values (?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, organizationName);
            preparedStmt.setString   (2, "Organization");
            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.organizationName = organizationName;
    }

    public Organization(String organizationName, String firstNameContact, String lastNameContact, String description) {
        this.organizationName = organizationName;
        this.firstNameContact = firstNameContact;
        this.lastNameContact = lastNameContact;
        this.description = description;
    }

    public Organization(String street, String city, String stateName, String phone, String email, String organizationName,
                        String firstNameContact, String lastNameContact, String description) {
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

    public void setFirstNameContact(String firstNameContact)
    {
        this.firstNameContact = firstNameContact;
    }

    public String getLastNameContact()
    {
        return lastNameContact;
    }

    public void setLastNameContact(String lastNameContact)
    {
        this.lastNameContact = lastNameContact;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Organization{" +
                "organizationName='" + organizationName + '\'' +
                ", firstNameContact='" + firstNameContact + '\'' +
                ", lastNameContact='" + lastNameContact + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
