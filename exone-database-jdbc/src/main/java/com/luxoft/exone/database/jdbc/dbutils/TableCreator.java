package com.luxoft.exone.database.jdbc.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private static void createTable() {

        final String SQL_FILE = "DROP TABLE IF EXISTS FILE_STATISTIC;\r\n" + 
                                "CREATE TABLE FILE_STATISTIC(ID_FILE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_FILE),\r\n" + 
                                                            "LONGEST_FILE_WORD INT," +
                                                            "SHORTEST_FILE_WORD INT," +
                                                            "AVG_FILE_WORD INT," +
                                                            "AVG_LINE_LENGTH INT)";
        final String SQL_LINE = "DROP TABLE IF EXISTS LINE_STATISTIC;" +
                                "CREATE TABLE LINE_STATISTIC(ID_LINE INT AUTO_INCREMENT,\r\n" + 
                                                            "PRIMARY KEY (ID_LINE),\r\n" +
                                                            "ID_FILE INT," + 
                                                            "LONGEST_WORD INT," +
                                                            "SHORTEST_WORD INT," +
                                                            "AVG_WORD INT," +
                                                            "LINE_LENGTH INT, " +
                                                            "FOREIGN KEY (ID_FILE) REFERENCES FILE_STATISTIC (ID_FILE))";

        try (Connection con = DBConnector.getConnection();
             Statement stmtFile = con.createStatement()) {
             Statement stmtLine = con.createStatement();
             
             stmtFile.executeUpdate(SQL_FILE);
             stmtLine.executeUpdate(SQL_LINE);
            

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
