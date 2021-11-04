package com.cydeo.day01;

import java.sql.*;

public class TestOracleConnection {
    public static void main(String[] args) {

        //making initial connection to oracle database
        //add driver dependency in pom file

        //find out connection info: jdbc url, or connection string. It is usually given to us
        //jdbc:oracle:thin@54.227.198.35:XE
        //ip: 54.227.198.35

        //username:hr
        //password:hr

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        //to make connection, we need variables to store connection, we use DriverManager class
        //every method in JDBC throws an checked exception, that has to be handled or declared
        try {

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");

            //create statement by using connection object and it has method createStatement
            Statement stat = con.createStatement();

            //using this statement object to run query
            ResultSet rs = stat.executeQuery("select * from regions" );
            rs.next(); //moves to first row
            //now we can use get String()    to get regions name
            System.out.println( rs.getString("REGION_NAME"));
            System.out.println( rs.getString("REGION_NAME"));
            rs.next();
            System.out.println( rs.getString("REGION_NAME"));


        } catch (SQLException e) {

            System.out.println("Error while connecting" + e.getMessage());
            e.printStackTrace();
        }


    }


}
