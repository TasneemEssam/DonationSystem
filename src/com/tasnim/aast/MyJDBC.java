package com.tasnim.aast;

import java.sql.*;

public class MyJDBC {

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Donor", "tasneem", "123456" );
            Statement statement = connection.createStatement();
            String selectAllDonor = " select * from donors ";
            String selectAllDonation = " select * from donations ";

            ResultSet resultSet1 = statement.executeQuery(selectAllDonor);
            ResultSet resultSet2 = statement.executeQuery(selectAllDonor);

            while(resultSet1.next()){
                //Display values
                System.out.print("ID: " + resultSet1.getInt("id"));
                System.out.print(", First: " + resultSet1.getString("firstName"));
                System.out.println(", Last: " + resultSet1.getString("lastName"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
