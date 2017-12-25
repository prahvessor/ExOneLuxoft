package com.luxoft.exone.database.jdbc.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private static void createTable() {

        final String SQL_LINE = "DROP TABLE IF EXISTS LINESTATISTIC;" +
                                "CREATE TABLE LINESTATISTIC(ID_LINE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_LINE),\r\n" + 
                                                            "LONGEST_WORD INT," +
                                                            "SHORTEST_WORD INT," +
                                                            "AVG_WORD INT," +
                                                            "LINE_LENGTH INT)";
        final String SQL_FILE = "DROP TABLE IF EXISTS FILESTATISTIC;\r\n" + 
                                "CREATE TABLE FILESTATISTIC(ID_FILE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_FILE),\r\n" + 
                                                            "LONGEST_FILE_WORD INT," +
                                                            "SHORTEST_FILE_WORD INT," +
                                                            "AVG_FILE_WORD INT," +
                                                            "AVG_LINE_LENGTH INT)";

        try (Connection con = DBConnector.getConnection();
             Statement stmtLine = con.createStatement();
             Statement stmtFile = con.createStatement()) {

            stmtLine.executeUpdate(SQL_LINE);
            stmtFile.executeUpdate(SQL_FILE);

        }catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Table LINESTATISTIC created");
        System.out.println("Table FILESTATISTIC created");
    }

    public static void main(String[] args) throws SQLException {

        createTable();

    }
}
