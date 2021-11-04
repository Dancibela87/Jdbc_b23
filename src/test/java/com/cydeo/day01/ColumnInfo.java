package com.cydeo.day01;

import java.sql.*;

public class ColumnInfo {

    public static void main(String[] args)throws SQLException {

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        Connection con = DriverManager.getConnection(url,username, password);
        //exception here is declared by throwing exception in method signature

        // Statement stat = con.createStatement();
        //the following set will give you option to use another methods
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = st.executeQuery("select * from employees");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        String firstColumnName = rsmd.getColumnName(1);
        System.out.println("firstColumnName = " + firstColumnName);

        //we can use loop to get all the column names
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("Column index is " + i);
            System.out.println(" | Column name is " + rsmd.getColumnName(i));
        }


        //getting cell value using rs.getString(columnName or columnIndex)
        //let's get cell value using column index
        //get employee_id in first column in two rows : the value 100

        rs.next();
        System.out.println("rs.getString(\"employee_id\") = " + rs.getString("employee_id"));
        System.out.println("rs.getString(1) = " + rs.getString(1));

        //print out entire first row

        for (int i = 1; i <= columnCount; i++) {
            System.out.println("rsmd.getColumnName(i) = " + rsmd.getColumnName(i));
            System.out.println("rs.getString(i) = " + rs.getString(i));

        }

        rs.next(); // now we are at the second row

        for (int i = 1; i <= columnCount; i++) {
            System.out.println("rsmd.getColumnName(i) = " + rsmd.getColumnName(i));
            System.out.println("rs.getString(i) = " + rs.getString(i));

        }




















    }
}
