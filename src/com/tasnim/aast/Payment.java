package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Payment {
    private String paymentID;
    private int  paymentValue;

    public Payment(int paymentValue, Connection connection) {
        String query = " insert into payment (paymentValue) values (?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setFloat   (1, paymentValue);

            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        return "\nPayment{" +
                "paymentID='" + paymentID + '\'' +
                ", paymentValue=" + paymentValue +
                '}';
    }
}
