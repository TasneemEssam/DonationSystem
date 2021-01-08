package com.tasnim.aast;

import java.util.UUID;

public class Payment {
    private String paymentID;
    private int  paymentValue;

    public Payment(int paymentValue) {
        this.paymentID= UUID.randomUUID().toString();
        this.paymentValue = paymentValue;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public int getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(int paymentValue) {
        this.paymentValue = paymentValue;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", paymentValue=" + paymentValue +
                '}';
    }
}
