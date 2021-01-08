package com.tasnim.aast;

public class Monetary  extends  Donation{
    //composition
    private Payment payment;

    public Monetary(Donor donor, Event event, Designation designation,int paymentValue) {
        super(donor, event, designation);
        payment = new Payment(paymentValue);
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return super.toString()+"Monetary{" +
                "payment=" + payment +
                '}';
    }
}
