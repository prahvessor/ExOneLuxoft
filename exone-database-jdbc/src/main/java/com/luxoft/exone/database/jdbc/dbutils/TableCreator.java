package com.luxoft.exone.database.jdbc.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private static void createTable() {

        final String SQL_LINE = "DROP TABLE IF EXISTS LINESTATISTIC;" +
                                "CREATE TABLE LINESTATISTIC(ID_LINE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_LINE),\r\n" + 
                                                            "LONGEST_WORD NUMERIC(2)," +
                                                            "SHORTEST_WORD NUMERIC(2)," +
                                                            "AVG_WORD NUMERIC(2)," +
                                                            "LINE_LENGTH NUMERIC(3))";
        final String SQL_FILE = "DROP TABLE IF EXISTS FILESTATISTIC;\r\n" + 
                                "CREATE TABLE FILESTATISTIC(ID_FILE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_FILE),\r\n" + 
                                                            "LONGEST_FILE_WORD NUMERIC(2)," +
                                                            "SHORTEST_FILE_WORD NUMERIC(2)," +
                                                            "AVG_FILE_WORD NUMERIC(2)," +
                                                            "AVG_LINE_LENGTH NUMERIC(3))";

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
