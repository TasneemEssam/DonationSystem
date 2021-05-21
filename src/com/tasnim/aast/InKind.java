package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InKind extends Donation {
    private  String description;

    public InKind(Donor donor, Event event, Designation designation, String description, Connection connection) {
        super(donor,event,designation);
        String query = " insert into donations (donner_id, designation_id, event_id,description, type) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 1);
            preparedStmt.setInt (2, 1);
            preparedStmt.setInt   (3, 1);
            preparedStmt.setString   (4, description);
            preparedStmt.setString   (5, "inkind");

            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "InKind{" +
                "description='" + description + '\'' +
                '}';
    }
}
