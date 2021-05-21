package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Monetary  extends  Donation{
    //composition
    private Payment payment;

    public Monetary(Donor donor, Event event, Designation designation, int paymentValue, Connection connection) {
        super(donor, event, designation);
        String query = " insert into donations (donner_id, designation_id, event_id,price, type) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 1);
            preparedStmt.setInt (2, 1);
            preparedStmt.setInt   (3, 1);
            preparedStmt.setFloat   (4, paymentValue);
            preparedStmt.setString   (5, "Monetary");

            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        payment = new Payment(paymentValue,connection);
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Monetary{" +
                "payment=" + payment +
                '}';
    }
}
