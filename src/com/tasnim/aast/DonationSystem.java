package com.tasnim.aast;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DonationSystem {
    private final ArrayList<Donation> donations;
    private final ArrayList<Donor> donors;
    private final ArrayList<Event> events;
    private final ArrayList<Designation> designations;
    private Connection connection;

    public DonationSystem() {
        this.donors = new ArrayList<>();  //creating an array list of donors
        this.donations =new ArrayList<>();  //creating an array list of donations
        this.events=new ArrayList<>();  //creating an array list of events
        this.designations = new ArrayList<>();  //creating an array list of designation
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost/Donor", "tasneem", "123456" );
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void listDonors(){
//        if(this.donors.size()==0) {
//            System.out.println("The donors is empty");
//            return;
//        }


        try {
            Statement statement = connection.createStatement();
            String selectAllDonor = " select * from donors ";
            ResultSet resultSet = statement.executeQuery(selectAllDonor);
            while(resultSet.next()){
                //Display values
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print(", First: " + resultSet.getString("firstName"));
                System.out.print(", Last: " + resultSet.getString("lastName"));
                System.out.print(", Organization Name: "+ resultSet.getString("organizationName"));
                System.out.println(", Type: "+ resultSet.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int index=0;
        for(Donor donor : this.donors){
            System.out.println((index++)+". ");
        }

    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void listEvents(){
//        if(this.events.size()==0) {
//            System.out.println("The events is empty");
//            return;
//        }
        try {
            Statement statement = connection.createStatement();
            String selectAllEvent = " select * from event ";
            ResultSet resultSet = statement.executeQuery(selectAllEvent);
            while(resultSet.next()){
                //Display values
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.println(", Name: " + resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int index=0;
        for(Event event : this.events){
            System.out.println((index++)+". "+event.toString());
        }
    }

    public void listDesignation(){
//        if(this.designations.size()==0) {
//            System.out.println("The designation is empty");
//            return;
//        }
        try {
            Statement statement = connection.createStatement();
            String selectAllDesignation = " select * from designation ";
            ResultSet resultSet = statement.executeQuery(selectAllDesignation);
            while(resultSet.next()){
                //Display values
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.println(", Name: " + resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int index=0;
        for(Designation designation : this.designations){
            System.out.println((index++)+". "+designation.toString());
        }
    }
//instanceof is a keyword that is used for checking if a reference variable donation is containing a given type of object reference or not- Monetary
    public void listMonetaryDonations(){
        for (Donation donation: this.donations){
            if (donation instanceof Monetary)
                System.out.println(donation.toString());
        }
    }

    public void listInKindDonations(){
        for (Donation donation: this.donations){
            if (donation instanceof InKind)
                System.out.println(donation.toString());
        }
    }

    public void listDonations(){
        for (Donation donation: this.donations){
            System.out.println(donation.toString());
        }
        try {
                Statement statement = connection.createStatement();
                String selectAllDonations = " select * from donations ";
                ResultSet resultSet = statement.executeQuery(selectAllDonations);
                while(resultSet.next()){
                    //Display values
                    System.out.print("ID: " + resultSet.getInt("id"));
                    System.out.print(", Donor_ID: " + resultSet.getString("donner_id"));
                    System.out.print(", Designation_ID: " + resultSet.getString("designation_id"));
                    System.out.print(", Type: " + resultSet.getString("type"));
                    System.out.print(", Description: " + resultSet.getString("description"));
                    System.out.println(", Price: " + resultSet.getString("price"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
    public void listIndividualDonors(){
        for (Donor donor: this.donors){
            if (donor instanceof Individual)
                System.out.println(donor.toString());
        }
    }



    Individual singUpIndividual(String street,String city, String stateName, String phone, String email, String userName, String password, boolean isAdmin, String firstName, String lastName) {
        try {

            return (Individual) createIndividualDonor(street, city,stateName, phone,email,userName,password,isAdmin,firstName,lastName) ;
    } catch (Exception error) {
        error.printStackTrace();
        return  null;
    }
    }

    Individual loginIndividual(String userName, String password) {
        if( Individual.checkUserExist(connection,userName, password)){
            return Individual.getUser(connection,userName);
        };
        return  null ;
    }

//    public void makeDonation(Scanner sc ){
//        Donor donor =selectDonor(sc);
//        Designation designation = selectDesignation(sc);
//        Event event = selectEvent(sc);
//        Donation donation = createDonations(sc, donor,designation,event);
//        if(!this.donors.contains(donor))
//           this.donors.add(donor);
//        if(!this.designations.contains(designation))
//           this.designations.add(designation);
//        if(!this.events.contains(event))
//           this.events.add(event);
//
//        this.donations.add(donation);
//    }
//    public  void updateDonor(Scanner sc){
//        if(this.donors.size()>0) {
//            System.out.println("0. to stop update");
//            System.out.println("1. to update individual");
//            System.out.println("2. to update organization");
//            int selection = sc.nextInt();
//            switch (selection) {
//                case 0 : {
//                }
//                break;
//
//                case 1: {
//                    ArrayList<Individual> individuals = new ArrayList<>();
//                    for (Donor donor : donors) {
//                        if (donor instanceof Individual)
//                            individuals.add((Individual) donor);
//                    }
//                    if(individuals.size()>0) {
//                        int index = 0;
//                        for (Individual individual : individuals) {
//                            System.out.println((index++) + " " + individual.donorIdentity());
//                        }
//                        int individualIndex =sc.nextInt();
//                        if(individualIndex<0 ||individualIndex>individuals.size()) return;
//                        updateDonorIndividual(sc,individuals.get(individualIndex));
//                    }else{
//                        System.out.println("empty individual");
//                    }
//                }
//                break;
//
//                case 2:{
//                    ArrayList<Organization> organizations = new ArrayList<>();
//                    for (Donor donor : donors) {
//                        if (donor instanceof Organization)
//                            organizations.add((Organization) donor);
//                    }
//                    if(organizations.size()>0) {
//                        int index = 0;
//                        for (Organization organization : organizations) {
//                            System.out.println((index++) + " " + organization.donorIdentity());
//                        }
//                        int organizationIndex =sc.nextInt();
//                        if(organizationIndex<0 ||organizationIndex>organizations.size()) return;
//                        updateDonorOrganization(sc,organizations.get(organizationIndex));
//                    }else{
//                        System.out.println("empty Organization");
//                    }
//
//                }
//            }
//        }else{
//            System.out.println("empty Donor");
//        }
//
//    }
//    private void updateDonorIndividual(Scanner sc,Individual individual){
//        System.out.println("enter first name");
//        individual.setFirstName(sc.next());
//        System.out.println("Enter last name");
//        individual.setLastName(sc.next());
//        System.out.println("Enter email");
//        individual.setEmail(sc.next());
//        System.out.println("Enter the phone number");
//        individual.setPhone(sc.next());
//        System.out.println("Enter the street");
//        individual.setStreet(sc.next());
//        System.out.println("Enter the city");
//        individual.setCity(sc.next());
//        System.out.println("Enter the State");
//        individual.setStateName(sc.next());
//        }

    private void updateDonorOrganization(Scanner sc,Organization organization){
        System.out.println("Enter organization name");
        organization.setOrganizationName(sc.next());
        System.out.println("Enter first name contact");
        organization.setFirstNameContact(sc.next());
        System.out.println("Enter last name contact");
        organization.setLastNameContact(sc.next());
        System.out.println("Enter organization description");
        organization.setDescription(sc.next());
        }

    private Donation createDonations(Scanner sc, Donor donor, Designation designation, Event event) {
      Donation donation =null;
        do{
            System.out.println("1) create Monetary Donation  ");
            System.out.println("2) create InKind Donation ");
            int selection= sc.nextInt();
            switch (selection){
                case 1: donation=createMonetary(sc,donor,designation,event);
                    break;

                case 2: donation=createInKind(sc,donor,designation,event);
                    break;

                default: donation=null;
            }
        }while(donation == null);
        return  donation;
    }

//    private Donor selectDonor(Scanner sc){
//      Donor donor = null;
//        do{
//            System.out.println("1) create new donor ");
//            System.out.println("2) List donors To pick one ");
//            int selection= sc.nextInt();
//            switch (selection){
//                case 1: donor=createDonor(sc);
//                    break;
//
//                case 2: donor=pickDonor(sc);
//                    break;
//
//                default: donor=null;
//            }
//        }while(donor == null);
//
//        return  donor;
//    }


    public Donor createIndividualDonor( String street, String city, String stateName, String phone, String email, String userName, String password, boolean isAdmin, String firstName, String lastName) {

     return  new Individual(connection,street, city,stateName, phone,email,userName,password,isAdmin,firstName,lastName,true);
    }

    private Donor pickDonor(Scanner sc) {
        this.listDonors();
        if(this.donors.size()>0) {
            System.out.println("Select out of bound to skip selection");
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.donors.size()) {
                System.out.println("Sorry you have pick invalid index");
                return null;
            }
            return this.donors.get(selection);
        }
        return  null;
    }

    private Designation selectDesignation(Scanner sc) {
        Designation designation = null;
        do{
            System.out.println("1) create new designation ");
            System.out.println("2) List designations To pick one ");
            int selection= sc.nextInt();
            switch (selection){
                case 1 : designation=createDesignation(sc);
                    break;

                case 2 : designation=pickDesignation(sc);
                    break;

                default: designation=null;
            }
        }while(designation == null);
        return designation;
    }


    private Designation createDesignation(Scanner sc) {
        System.out.println("Enter the designation name");
        String designationName = sc.next();
        return  new Designation(designationName,connection);
    }

    private Designation pickDesignation(Scanner sc) {
        this.listDesignation();
        if(this.designations.size()>0) {
            System.out.println("Select out of bound to skip selection");
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.designations.size()) {
                System.out.println("Sorry you have pick invalid index");
                return null;
            }
            return this.designations.get(selection);
        }
        return null;
    }

    private Event selectEvent(Scanner sc) {
        Event event = null;
        do{
            System.out.println("1) create new Event ");
            System.out.println("2) List events To pick one ");

            int selection= sc.nextInt();
            switch (selection){
                case 1: event=createEvent(sc);
                    break;

                case 2: event=pickEvent(sc);
                    break;

                default : event=null;
            }
        }while(event == null);

        return  event;
    }


    private Event createEvent(Scanner sc) {
        System.out.println("Enter event name");

        String eventName = sc.next();
        return  new Event(eventName,connection);
    }

    private Event pickEvent(Scanner sc) {
        this.listEvents();
        if(this.events.size()>0) {
            System.out.println("Select out of bound to skip selection");
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.events.size()) {
                System.out.println("Sorry you have pick invalid index");
                return null;
            }
            return this.events.get(selection);
        }
        return  null;
    }


    private Donation createMonetary(Scanner sc, Donor donor, Designation designation, Event event) {
        System.out.println("Enter the payment Amount -> Integer");
        int value = sc.nextInt();
        return new Monetary(donor,event,designation,value,connection);
    }

    private Donation createInKind(Scanner sc, Donor donor, Designation designation, Event event) {
        System.out.println("Enter the Inkind description -> String");
        String desc = sc.next();
        return new InKind(donor,event,designation,desc,connection);
    }

}
