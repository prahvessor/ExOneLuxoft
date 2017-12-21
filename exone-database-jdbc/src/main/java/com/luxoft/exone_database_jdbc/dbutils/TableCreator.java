package com.luxoft.exone_database_jdbc.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private static void createTable() {

        final String SQL_LINE = "CREATE TABLE LINESTATISTIC(MAX_WORD NUMERIC(2),MIN_WORD NUMERIC(2),AVG_WORD NUMERIC(2),LINE_LENGTH NUMERIC(3))";
        final String SQL_FILE = "CREATE TABLE FILESTATISTIC(MAX_FILE_WORD NUMERIC(2),MIN_FILE_WORD NUMERIC(2),AVG_FILE_WORD NUMERIC(2),AVG_LINE_LENGTH NUMERIC(3))";

        try (Connection con = DBUtils.getConnection();
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
