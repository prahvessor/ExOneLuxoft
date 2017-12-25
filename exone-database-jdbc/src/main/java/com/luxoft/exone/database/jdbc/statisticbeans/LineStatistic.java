package com.luxoft.exone.database.jdbc.statisticbeans;

import java.util.Arrays;

public class LineStatistic {

    private final int longestWord;
    private final int shortestWord;
    private final int avgWord;
    private final int lineLength;

    public LineStatistic(String line) {

        String[] words = line.trim().split(" ");

        longestWord = findLongest(words);
        shortestWord = findShortest(words);
        avgWord = (longestWord + shortestWord)/2;
        lineLength = line.length();
    }
    
    @Override
    public String toString() {
        return "[longestWord:" + longestWord + ", shortestWord:" + shortestWord + ", avgWord:" + avgWord + ", lineLength:" + lineLength +"]";
    }

    public int getLongestWord() {
        return longestWord;
    }
    public int getShortestWord() {
        return shortestWord;
    }
    public int getAvgWord() {
        return avgWord;
    }
    public int getLineLength() {
        return lineLength;
    }
    
    public static int findLongest(String[] words) {
        int[] wordsLength = findWordLength(words);
        return wordsLength[wordsLength.length -1];
    }

    public static int findShortest(String[] words) {
        int[] wordsLength = findWordLength(words);
        return wordsLength[0];
    }
    
    private static int[] findWordLength(String[] words) {
        int[] wordsLength = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsLength[i] = words[i].length();
        }
        Arrays.sort(wordsLength);
        return wordsLength;
    }

}