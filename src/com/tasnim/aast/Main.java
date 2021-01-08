package com.tasnim.aast;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DonationSystem donationSystem = new DonationSystem();
        int selector ;
        do {
            System.out.println("0- to stop executions");
            System.out.println("1- to make donation");
            System.out.println("2- list all donation");
            System.out.println("3- list all monetary donation");
            System.out.println("4- list all inkind donation");
            System.out.println("5- list all donors");
            System.out.println("6- list all individual donor");
            System.out.println("7- list all organization donor");
            System.out.println("8- list all designations");
            System.out.println("9- list all events");



            selector = sc.nextInt();
            switch (selector){
                case 1-> donationSystem.makeDonation(sc);
                case 2-> donationSystem.listDonations();
                case 3-> donationSystem.listMonetaryDonations();
                case 4-> donationSystem.listInKindDonations();
                case 5-> donationSystem.listDonors();
                case 6-> donationSystem.listIndividualDonors();
                case 7-> donationSystem.listOrganizationDonors();
                case 8-> donationSystem.listDesignation();
                case 9-> donationSystem.listEvents();
            }
        }while(selector!= 0);
    }
}
