package com.luxoft.exone_database_jdbc;

public class LineStatistic {

    private final int maxWord;
    private final int minWord;
    private final int avgWord;
    private final int lineLength;

    public LineStatistic(String line) {

        String[] words = line.trim().split(" ");

        maxWord = Calculator.getLongest(words);
        minWord = Calculator.getShortest(words);
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

}