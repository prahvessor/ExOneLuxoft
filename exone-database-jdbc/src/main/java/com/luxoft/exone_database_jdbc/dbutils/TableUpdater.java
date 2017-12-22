package com.luxoft.exone_database_jdbc.dbutils;

import com.luxoft.exone_database_jdbc.statisticbeans.FileStatistic;
import com.luxoft.exone_database_jdbc.statisticbeans.LineStatistic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableUpdater {

    public void updateTable(FileStatistic fileStatistic) {

        String sqlLine ="INSERT INTO LINESTATISTIC VALUES(?,?,?,?)";
        String sqlFile ="INSERT INTO FILESTATISTIC VALUES(?,?,?,?)";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement prStatementLine = connection.prepareStatement(sqlLine);
             PreparedStatement prStatementFile = connection.prepareStatement(sqlFile)) {

            for (LineStatistic lineStatistic : fileStatistic.getLineStatisticList()) {

                updateTable(prStatementLine,
                        lineStatistic.getLongestWord(),
                        lineStatistic.getShortestWord(),
                        lineStatistic.getAvgWord(),
                        lineStatistic.getLineLength());

            }

            updateTable(prStatementFile,
                    fileStatistic.getMaxFileWord(),
                    fileStatistic.getMinFileWord(),
                    fileStatistic.getAvgFileWord(),
                    fileStatistic.getAvgFileLineLength());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(PreparedStatement prStatement, int max, int min, int avg, int line) throws Exception{

        prStatement.setInt(1, max);
        prStatement.setInt(2, min);
        prStatement.setInt(3, avg);
        prStatement.setInt(4, line);

        prStatement.executeUpdate();
    }
}
