package com.luxoft.exone_database_jdbc;

import java.util.List;

class Calculator {

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

    public static int getLongest(String[] strArr) {
        int longest = 10;
        return longest;
    }

    public static int getShortest(String[] strArr) {
        int shortest = 1;
        return shortest;
    }

}
