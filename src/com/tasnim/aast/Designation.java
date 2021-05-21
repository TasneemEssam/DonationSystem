package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Designation {
 private String designationID;
 private String designationName;

    public Designation(String designationName, Connection connection) {
        String query = " insert into designation (name) values (?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, designationName);
            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getDesignationID() {
        return designationID;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    @Override
    public String toString() {
        return "\nDesignation{" +
                "designationID='" + designationID + '\'' +
                ", designationName='" + designationName + '\'' +
                '}';
    }
}
