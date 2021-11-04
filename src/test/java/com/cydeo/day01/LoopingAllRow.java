package com.cydeo.day01;

import java.sql.*;

public class LoopingAllRow {
    public static void main(String[] args)throws SQLException {

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        Connection con = DriverManager.getConnection(url,username, password);
        //exception here is declared by throwing exception in method signature

        Statement stat = con.createStatement();
        //the following set will give you option to use another methods
       // Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stat.executeQuery("select * from regions");
        //loop through all rows and print items

        //rs.next() move to next row
        //return true if it is valid, false, if not
        //so, we can use it in while condition

        while (rs.next() ){

            System.out.println("rs.getString(\"region_id\") = " + rs.getString("region_id"));
            System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));


        }

        rs.previous();
        System.out.println("rs.getString(\"region_id\") = " + rs.getString("region_id"));
        //this will give exception, because there are no more rows





    }
}
