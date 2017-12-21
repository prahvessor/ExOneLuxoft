package com.luxoft.exone_database_jdbc.statisticbeans;

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

        maxFileWord = getFileLongest(lineStatisticList);
        minFileWord = getFileShortest(lineStatisticList);
        avgFileWord = getFileAvg(lineStatisticList);
        avgFileLineLength = getFileAvgLine(lineStatisticList);
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

    public static int getFileLongest(List<LineStatistic> lineStatistic){
        int maxFileWord = 10;
        return maxFileWord;
    }

    public static int getFileShortest(List<LineStatistic> lineStatistic){
        int minFileWord = 1;
        return minFileWord;
    }

    public static int getFileAvg(List<LineStatistic> lineStatistic){
        int avgFileWord = 5;
        return avgFileWord;
    }

    public static int getFileAvgLine(List<LineStatistic> lineStatistic){
        int fileAvgLineLength = 5;
        int listLength = lineStatistic.size();
        return fileAvgLineLength/listLength;
    }
}
