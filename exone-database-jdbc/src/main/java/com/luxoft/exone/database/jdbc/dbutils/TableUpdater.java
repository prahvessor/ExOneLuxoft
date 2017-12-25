package com.luxoft.exone.database.jdbc.dbutils;

import com.luxoft.exone.database.jdbc.statisticbeans.FileStatistic;
import com.luxoft.exone.database.jdbc.statisticbeans.LineStatistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TableUpdater {

    public void updateTable(List<FileStatistic> fileStatisticList) {

        String sqlLine ="INSERT INTO LINESTATISTIC(LONGEST_WORD, SHORTEST_WORD, AVG_WORD, LINE_LENGTH) VALUES(?,?,?,?)";
        String sqlFile ="INSERT INTO FILESTATISTIC(LONGEST_FILE_WORD, SHORTEST_FILE_WORD, AVG_FILE_WORD, AVG_LINE_LENGTH) VALUES(?,?,?,?)";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement prStatementLine = connection.prepareStatement(sqlLine);
             PreparedStatement prStatementFile = connection.prepareStatement(sqlFile)) {
            
            for (FileStatistic fileStatistic : fileStatisticList) {
                
                updateTable(prStatementFile,
                        fileStatistic.getLongestFileWord(),
                        fileStatistic.getShortestFileWord(),
                        fileStatistic.getAvgFileWord(),
                        fileStatistic.getAvgFileLineLength());
                
                for (LineStatistic lineStatistic : fileStatistic.getLineStatisticList()) {
                    
                    updateTable(prStatementLine,
                            lineStatistic.getLongestWord(),
                            lineStatistic.getShortestWord(),
                            lineStatistic.getAvgWord(),
                            lineStatistic.getLineLength());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(PreparedStatement prStatement, int longest, int shortest, int avg, int line) throws Exception{

        prStatement.setInt(1, longest);
        prStatement.setInt(2, shortest);
        prStatement.setInt(3, avg);
        prStatement.setInt(4, line);

        prStatement.executeUpdate();
    }
}
