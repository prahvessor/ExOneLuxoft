package com.luxoft.exone_database_jdbc.statisticbeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileStatistic {

    private final int longestFileWord;
    private final int shortestFileWord;
    private final int avgFileWord;
    private final int avgFileLineLength;
    private List<LineStatistic> lineStatisticList = new ArrayList<>();

    public FileStatistic(List<String> listOfLines) {

        int i = 0;
        for (String line: listOfLines) {
            lineStatisticList.add(i++, (new LineStatistic(line)));
        }

        longestFileWord = findFileLongest(lineStatisticList);
        shortestFileWord = findFileShortest(lineStatisticList);
        avgFileWord = findFileAvg(lineStatisticList);
        avgFileLineLength = findFileAvgLine(lineStatisticList);
    }

    public int getMaxFileWord() {
        return longestFileWord;
    }
    public int getMinFileWord() {
        return shortestFileWord;
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

    public static int findFileLongest(List<LineStatistic> lineStatistic){
        int[] allLongest = new int[lineStatistic.size()];
        for (int i = 0; i < lineStatistic.size(); i++) {
            allLongest[i] = lineStatistic.get(i).getLongestWord();
        }
        Arrays.sort(allLongest);
        return allLongest[lineStatistic.size()-1];
    }

    public static int findFileShortest(List<LineStatistic> lineStatistic){
        int[] allShortest = new int[lineStatistic.size()];
        for (int i = 0; i < lineStatistic.size(); i++) {
            allShortest[i] = lineStatistic.get(i).getShortestWord();
        }
        Arrays.sort(allShortest);
        return allShortest[0];
    }

    public static int findFileAvg(List<LineStatistic> lineStatistic){
        int[] parameters = new int[lineStatistic.size()];
        for (int i = 0; i < lineStatistic.size(); i++) {
            parameters[i] = lineStatistic.get(i).getAvgWord();
        }
        Arrays.sort(parameters);
        return (parameters[lineStatistic.size()-1] + parameters[0])/2;
    }

    public static int findFileAvgLine(List<LineStatistic> lineStatistic){
        int[] parameters = new int[lineStatistic.size()];
        for (int i = 0; i < lineStatistic.size(); i++) {
            parameters[i] = lineStatistic.get(i).getLineLength();
        }
        return (parameters[lineStatistic.size()-1] + parameters[0])/2;
    }
    
}
