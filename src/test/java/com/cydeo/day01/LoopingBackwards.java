package com.cydeo.day01;

import java.sql.*;

public class LoopingBackwards {

    public static void main(String[] args) throws SQLException{
        //run selectfrom employee where employee_id < 120
        //print employee_id column fromm last row till first

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE"; //always use for oracle
        String username = "hr";
        String password ="hr";

        Connection con = DriverManager.getConnection(url,username, password);
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from employees where employee_id < 120");
       // ResultSetMetaData rsmd = rs.getMetaData();

        //print employee_id column fromm last row till first

        rs.afterLast();

        while(rs.previous()){
            System.out.println("rs.getString(1) = " + rs.getString(1));
        }


        //after we are done with connection, statement, resource set , we need to close them, just like scanner, file input stream
        //the order of closing is opposite from the creation
        rs.close();
        st.close();
        con.close();








    }

}
