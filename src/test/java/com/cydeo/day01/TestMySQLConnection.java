package com.cydeo.day01;

import java.sql.*;

public class TestMySQLConnection {
    public static void main(String[] args) {

        String url ="jdbc:mysql://54.157.236.232:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Library DB connection successful");

            //create statement by using connection object and it has method createStatement
            Statement stat = con.createStatement();

            //using this statement object to run query
            ResultSet rs = stat.executeQuery("select * from books");


        } catch (SQLException e) {
            System.out.println("Error while connection" + e.getMessage());
            e.printStackTrace();
        }


    }
}
