package com.cydeo.day01;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PracticeConnection {
    public static void main(String[] args) throws SQLException {

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        Connection con = DriverManager.getConnection(url,username, password);
        //exception here is declared by throwing exception in method signature

        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("select * from regions");

        //navigate through result set  to  get cell value
        rs.next();//move the pointer from before first location to first row

        //use result set getX method like getString, getInt, getDouble to actually read data
        //read region id column and region name print it out
        System.out.println("rs.getString(\"region_id\") = " +
                            rs.getString("region_id"));
        System.out.println("rs.getString(\"region_name\") = " +
                            rs.getString("region_name"));

        //keep moving - now we are at the second row
        rs.next();
        System.out.println("rs.getString(\"region_id\") = " +
                            rs.getString("region_id"));
        System.out.println("rs.getString(\"region_name\") = " +
                            rs.getString("region_name"));

        //move to  third row
        rs.next();
        System.out.println("rs.getString(\"region_id\") = " +
                rs.getString("region_id"));
        System.out.println("rs.getString(\"region_name\") = " +
                rs.getString("region_name"));

        //move to forth row
        System.out.println("rs.next() = " + rs.next()); //this return true
        System.out.println("rs.getString(\"region_id\") = " +
                rs.getString("region_id"));
        System.out.println("rs.getString(\"region_name\") = " +
                rs.getString("region_name"));

        // after we print after last , we will get results before, but in that step, we will get exception
        // so, we have to loop through everything to avoid exceptions

        System.out.println("rs.next() = " + rs.next()); //it will return false, because there is no 5th row.













    }
}
