package com.luxoft.exone_database_jdbc;

import java.util.ArrayList;
import java.util.List;

public class FileStatistic {

    private final int maxFileWord;
    private final int minFileWord;
    private final int avgFileWord;
    private final int avgFileLineLength;
    private List<LineStatistic> lineStatisticList = new ArrayList<>();

    public FileStatistic(List<String> listOfLines) {

        int i = 0;
        for (String line: listOfLines) {
            lineStatisticList.add(i++, (new LineStatistic(line)));
        }

        maxFileWord = Calculator.getFileLongest(lineStatisticList);
        minFileWord = Calculator.getFileShortest(lineStatisticList);
        avgFileWord = Calculator.getFileAvg(lineStatisticList);
        avgFileLineLength = Calculator.getFileAvgLine(lineStatisticList);
    }

    public int getMaxFileWord() {
        return maxFileWord;
    }
    public int getMinFileWord() {
        return minFileWord;
    }
    public int getAvgFileWord() {
        return avgFileWord;
    }
    public int getAvgFileLineLength() {
        return avgFileLineLength;
    }
    public List<LineStatistic> getLineStatisticList() {
        return lineStatisticList;
    }

}
