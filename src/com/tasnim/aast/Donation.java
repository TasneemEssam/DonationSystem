package com.tasnim.aast;

import java.util.Date;
import java.util.UUID;

public abstract class Donation {
private String donationID ;
//Aggregation
private Donor donor;
private Event event;
private Designation designation;

private Date donationDate;

    public Donation(Donor donor, Event event, Designation designation) {
        this.donationID= UUID.randomUUID().toString();
        this.donor = donor;
        this.event = event;
        this.designation = designation;
        this.donationDate = new Date();
    }

    public String getDonationID() {
        return donationID;
    }

    public Donor getDonor() {
        return donor;
    }

    public Event getEvent() {
        return event;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    @Override
    public String toString() {
        return "\nDonation{" +
                "donationID='" + donationID + '\'' +
                ", donor=" + donor +
                ", event=" + event +
                ", designation=" + designation +
                ", donationDate=" + donationDate +
                '}';
    }
}
