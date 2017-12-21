package com.luxoft.exone_database_jdbc.statisticbeans;

public class LineStatistic {

    private final int maxWord;
    private final int minWord;
    private final int avgWord;
    private final int lineLength;

    public LineStatistic(String line) {

        String[] words = line.trim().split(" ");

        maxWord = getLongest(words);
        minWord = getShortest(words);
        avgWord = (maxWord + minWord)/2;
        lineLength = line.length();
    }

    public int getMaxWord() {
        return maxWord;
    }
    public int getMinWord() {
        return minWord;
    }
    public int getAvgWord() {
        return avgWord;
    }
    public int getLineLength() {
        return lineLength;
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