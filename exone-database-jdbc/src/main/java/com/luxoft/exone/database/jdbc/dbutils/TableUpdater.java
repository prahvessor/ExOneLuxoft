package com.luxoft.exone.database.jdbc.dbutils;

import com.luxoft.exone.database.jdbc.statisticbeans.FileStatistic;
import com.luxoft.exone.database.jdbc.statisticbeans.LineStatistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class TableUpdater {

    public void updateTable(List<FileStatistic> fileStatisticList) {

        String sqlLine ="INSERT INTO LINE_STATISTIC(ID_FILE, LONGEST_WORD, SHORTEST_WORD, AVG_WORD, LINE_LENGTH) VALUES(?,?,?,?,?)";
        String sqlFile ="INSERT INTO FILE_STATISTIC(LONGEST_FILE_WORD, SHORTEST_FILE_WORD, AVG_FILE_WORD, AVG_LINE_LENGTH) VALUES(?,?,?,?)";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement prStatementLine = connection.prepareStatement(sqlLine);
             PreparedStatement prStatementFile = connection.prepareStatement(sqlFile);
             Statement statementId = connection.createStatement();) {
            
            for (FileStatistic fileStatistic : fileStatisticList) {
                
                prStatementFile.setInt(1, fileStatistic.getLongestFileWord());
                prStatementFile.setInt(2, fileStatistic.getShortestFileWord());
                prStatementFile.setInt(3, fileStatistic.getAvgFileWord());
                prStatementFile.setInt(4, fileStatistic.getAvgFileLineLength());
                prStatementFile.executeUpdate();
                
                ResultSet rs = statementId.executeQuery("SELECT LAST_INSERT_ID() AS ID_FILE");
                int idFile = 0;
                while (rs.next()) {
                    idFile = rs.getInt("id_file");
                }
                
                for (LineStatistic lineStatistic : fileStatistic.getLineStatisticList()) {
                  
                    prStatementLine.setInt(1, idFile);
                    prStatementLine.setInt(2, lineStatistic.getLongestWord());
                    prStatementLine.setInt(3, lineStatistic.getShortestWord());
                    prStatementLine.setInt(4, lineStatistic.getAvgWord());
                    prStatementLine.setInt(5, lineStatistic.getLineLength());
                    prStatementLine.executeUpdate();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
