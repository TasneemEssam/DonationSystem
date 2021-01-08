package com.tasnim.aast;

import java.util.ArrayList;
import java.util.Scanner;

public class DonationSystem {
    private final ArrayList<Donation> donations;
    private final ArrayList<Donor> donors;
    private final ArrayList<Event> events;
    private final ArrayList<Designation> designations;

    public DonationSystem() {
        this.donors = new ArrayList<>();
        this.donations =new ArrayList<>();
        this.events=new ArrayList<>();
        this.designations = new ArrayList<>();
    }

    public void listDonors(){
        if(this.donors.size()==0) {
            System.out.println("The donors is empty");
            return;
        }
        int index=0;
        for(Donor donor : this.donors){
            System.out.println((index++)+". "+donor.donorIdentity());
        }

    }

    public void listEvents(){
        if(this.events.size()==0) {
            System.out.println("The events is empty");
            return;
        }
        int index=0;
        for(Event event : this.events){
            System.out.println((index++)+". "+event.toString());
        }
    }

    public void listDesignation(){
        if(this.designations.size()==0) {
            System.out.println("The designation is empty");
            return;
        }
        int index=0;
        for(Designation designation : this.designations){
            System.out.println((index++)+". "+designation.toString());
        }
    }
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
    }

    public void makeDonation(Scanner sc ){
        Donor donor =selectDonor(sc);
        Designation designation = selectDesignation(sc);
        Event event = selectEvent(sc);
        Donation donation = createDonations(sc, donor,designation,event);
        if(!this.donors.contains(donor))
           this.donors.add(donor);
        if(!this.designations.contains(designation))
           this.designations.add(designation);
        if(!this.events.contains(event))
           this.events.add(event);

        this.donations.add(donation);
    }

    public void listIndividualDonors(){
        for (Donor donor: this.donors){
            if (donor instanceof Individual)
                System.out.println(donor.toString());
        }
    }


    public void listOrganizationDonors(){
        for (Donor donor: this.donors){
            if (donor instanceof Organization)
                System.out.println(donor.toString());
        }
    }

    private Donation createDonations(Scanner sc, Donor donor, Designation designation, Event event) {
      Donation donation =null;
        do{
            System.out.println("1) create Monetary Donation  ");
            System.out.println("2) create InKind Donation ");
            int selection= sc.nextInt();
            switch (selection){
                case 1 -> donation=createMonetary(sc,donor,designation,event);
                case 2 -> donation=createInKind(sc,donor,designation,event);
                default -> donation=null;
            }
        }while(donation == null);
        return  donation;
    }

    private Donor selectDonor(Scanner sc){
      Donor donor = null;
        do{
            System.out.println("1) create new donor ");
            System.out.println("2) List donors To pick one ");
            int selection= sc.nextInt();
            switch (selection){
                case 1 -> donor=createDonor(sc);
                case 2 -> donor=pickDonor(sc);
                default -> donor=null;
            }
        }while(donor == null);

        return  donor;
    }
    private Donor createDonor(Scanner sc) {
        Donor donor = null;
        do{
            System.out.println("1) create Individual  ");
            System.out.println("2) create Organization ");
            int selection= sc.nextInt();
            switch (selection){
                case 1 -> donor=createIndividualDonor(sc);
                case 2 -> donor=createOrganizationDonor(sc);
                default -> donor=null;
            }
        }while(donor == null);
        return  donor;
    }

    private Donor createOrganizationDonor(Scanner sc) {
        System.out.println("enter ur organizationName");
        String orgName =sc.next();
        return  new Organization(orgName);
    }

    private Donor createIndividualDonor(Scanner sc) {
        System.out.println("enter ur first name");
        String firstName =sc.next();
        System.out.println("enter ur sec name");
        String lastName =sc.next();

     return  new Individual(firstName,lastName);
    }

    private Donor pickDonor(Scanner sc) {
        this.listDonors();
        if(this.donors.size()>0) {
            System.out.println("select out of bound to skip selection");
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.donors.size()) {
                System.out.println("sorry u have pick invalid index");
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
                case 1 -> designation=createDesignation(sc);
                case 2 -> designation=pickDesignation(sc);
                default -> designation=null;
            }
        }while(designation == null);
        return designation;
    }


    private Designation createDesignation(Scanner sc) {
        System.out.println("enter the designation name");
        String designationName = sc.next();
        return  new Designation(designationName);
    }

    private Designation pickDesignation(Scanner sc) {
        this.listDesignation();
        if(this.designations.size()>0) {
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.designations.size()) {
                System.out.println("sorry u have pick invalid index");
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
                case 1 -> event=createEvent(sc);
                case 2 -> event=pickEvent(sc);
                default -> event=null;
            }
        }while(event == null);

        return  event;
    }


    private Event createEvent(Scanner sc) {
        System.out.println("enter event name");

        String eventName = sc.next();
        return  new Event(eventName);
    }

    private Event pickEvent(Scanner sc) {
        this.listEvents();
        if(this.events.size()>0) {
            int selection = sc.nextInt();
            if (selection < 0 || selection >= this.events.size()) {
                System.out.println("sorry u have pick invalid index");
                return null;
            }
            return this.events.get(selection);
        }
        return  null;
    }


    private Donation createMonetary(Scanner sc, Donor donor, Designation designation, Event event) {
        System.out.println("Enter the payment Amount -> Integer");
        int value = sc.nextInt();
        return new Monetary(donor,event,designation,value);
    }

    private Donation createInKind(Scanner sc, Donor donor, Designation designation, Event event) {
        System.out.println("Enter the Inkind description -> String");
        String desc = sc.next();
        return new InKind(donor,event,designation,desc);
    }

}
