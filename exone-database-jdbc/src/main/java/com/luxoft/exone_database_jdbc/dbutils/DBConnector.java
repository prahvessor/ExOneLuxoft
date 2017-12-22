package com.luxoft.exone_database_jdbc.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnector {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to load the driver. ");
        }
    }

    public static Connection getConnection(){

        Connection con = null;
        String urlHTwo = "jdbc:h2:~/test";
        String nameHTwo = "sa";
        String passwordHTwo = "";

        try {
            con = DriverManager.getConnection(urlHTwo, nameHTwo, passwordHTwo);
        } catch (Exception e) {
            System.out.println("Unable to get connection");
            e.printStackTrace();
        }
        return con;
    }
}
