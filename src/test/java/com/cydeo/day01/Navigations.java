package com.cydeo.day01;

import java.sql.*;

public class Navigations {


    public static void main(String[] args) throws SQLException {

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        Connection con = DriverManager.getConnection(url,username, password);
        //exception here is declared by throwing exception in method signature

        // Statement stat = con.createStatement();
        //the following set will give you option to use another methods
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = st.executeQuery("select * from employees");

        /**
         * next - goes to the next row and return true/false
         * previous - move to previous row and return true if we have valid row
         * first- move to first row from anywhere
         * last- move to last row from anywhere
         * beforeFirst - move to this location from everywhere
         * afterLast - move to this location from anywhere
         * absolute(8- move to any row by using row number
         */

        rs.next();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.last();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.previous();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.absolute(100);
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.first();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.afterLast();    //no result we will get here, if we print here, we will get exception
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.previous();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));

        rs.beforeFirst();

        //getting row number of current row the pointer is pointing to
        System.out.println("rs.getRow() = " + rs.getRow());

        rs.last();
        System.out.println("Total row count is " + rs.getRow());


    }
}
