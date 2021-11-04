package com.cydeo.day01;

import com.cydeo.utlity.ConfigReader;
import com.cydeo.utlity.DB_Util;

public class PracticeUtility {
    public static void main(String[] args) {

        //create connection to oracle database
        String url = ConfigReader.read("hr.database.url");
        String username = ConfigReader.read("hr.database.username");
        String password =ConfigReader.read("hr.database.password") ;

        DB_Util.createConnection(url,username,password);

        //run query so it can set up all resultSet stuff  and we can call method
        DB_Util.runQuery("select * from countries");

        //print the result of the query
        //DB_Util.displayAllData();

        //print out all column names
        System.out.println("DB_Util.getAllColumnNamesAsList() = "
                + DB_Util.getAllColumnNamesAsList());

        // print out 2row data as list
        System.out.println("DB_Util.getRowDataAsList(2) = "
                + DB_Util.getRowDataAsList(2));

        // print out 1st column data as list
        System.out.println("DB_Util.getColumnDataAsList(1) = "
                + DB_Util.getColumnDataAsList(1));

        // print out COUNTRY_NAME column data as list
        System.out.println("DB_Util.getColumnDataAsList(\"country_name\") = "
                + DB_Util.getColumnDataAsList("country_name"));

        // print out row count
        System.out.println("DB_Util.getRowCount() = "
                + DB_Util.getRowCount());

        // print out column count
        System.out.println("DB_Util.getColumnCount() = "
                + DB_Util.getColumnCount());

        // print out the value of row number 4 column number 1
        System.out.println("DB_Util.getCellValue(4,1) = "
                + DB_Util.getCellValue(4, 1));

        // print out the value of row number 10 and COUNTRY_ID column
        System.out.println("DB_Util.getCellValue(10,\"country_id\") = "
                + DB_Util.getCellValue(10, "country_id"));

        // print out the first row first cell value
        System.out.println("DB_Util.getFirstRowFirstColumn() = "
                + DB_Util.getFirstRowFirstColumn());

        // print out 3rd row as Map
        System.out.println("DB_Util.getRowMap(3) = "
                + DB_Util.getRowMap(3));

        // print out all row as List of Map
        System.out.println("DB_Util.getAllRowAsListOfMap() = "
                + DB_Util.getAllRowAsListOfMap());

        //close the connection
        DB_Util.destroy();






    }





}
