package com.tasnim.aast;
import java.sql.*;

public class Individual  extends  Donor{
    private String firstName;
    private String lastName;


     Individual( Connection connection, String street, String city, String stateName, String phone, String email, String userName, String password, boolean isAdmin, String firstName, String lastName,boolean insert) {
        super(street, city, stateName, phone, email,userName,password,isAdmin);
        this.firstName= firstName;
        this.lastName=lastName;
        if(insert)
        insertDonor(connection,street, city,stateName, phone,email,userName,password,isAdmin,firstName,lastName);
    }

    private void insertDonor (Connection connection, String street, String city, String stateName, String phone, String email, String userName, String password, boolean isAdmin, String firstName, String lastName) {
        String query = " insert into donors (firstName, lastName, type, isAdmin, userName, password, email, phone, stateName, city, street) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, firstName);
            preparedStmt.setString (2, lastName);
            preparedStmt.setString   (3, "individual");

            preparedStmt.setBoolean   (4, isAdmin);
            preparedStmt.setString   (5, userName);
            preparedStmt.setString   (6, password);
            preparedStmt.setString   (7, email);
            preparedStmt.setString   (8, phone);
            preparedStmt.setString   (9, stateName);
            preparedStmt.setString   (10, city);
            preparedStmt.setString   (11, street);

            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public  static  boolean checkUserExist (Connection connection,String userName, String password){
        try {
            String pickDonor = " select * from donors ";
            Statement statement = connection.createStatement();

        ResultSet res = statement.executeQuery(pickDonor);

        if(res.next()){
            //Display values
            String confirmedPassword = res.getString("password");
            if(confirmedPassword.equals(password)) return  true;
        }
        return  false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        }

    }

    public  static  Individual getUser (Connection connection,String userName){
        try {
            String pickDonor = " select * from donors ";
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(pickDonor);

            if(res.next()){
                //Display values
//                firstName, lastName, type, isAdmin, userName, password, email, phone, statename, city, street
                String password = res.getString("password");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String type = res.getString("type");
                boolean isAdmin =res.getBoolean("isAdmin");
                String email = res.getString("email");
                String phone = res.getString("phone");
                String stateName = res.getString("stateName");
                String city = res.getString("city");
                String street = res.getString("street");
                return  new Individual(connection,street, city,stateName, phone,email,userName,password,isAdmin,firstName,lastName,false);
            }
            return  null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }

    }
    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Individual{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
