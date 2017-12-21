package com.luxoft.exone_database_jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.luxoft.exone_database_jdbc.statisticbeans.FileStatistic;
import com.luxoft.exone_database_jdbc.statisticbeans.LineStatistic;

public class CalculatorTest {

    public static List<LineStatistic> lineStatisticListTest = new ArrayList<>();

    @BeforeClass
    public static void testSetup() {
        String words1 = "123456789 12 12345";
        String words2 = "1234567 12 1234";
        String words3 = "123456789 1 12345";
        String words4 = "123456 12 1234";
        lineStatisticListTest.add(0, new LineStatistic(words1));
        lineStatisticListTest.add(1, new LineStatistic(words2));
        lineStatisticListTest.add(2, new LineStatistic(words3));
        lineStatisticListTest.add(3, new LineStatistic(words4));
    }
    
    @Test
    public void shouldFindLongestWordInFile() throws Exception {
        assertEquals("The longest word must be 9", 9, FileStatistic.getFileLongest(lineStatisticListTest));
    }

    @Test
    public void shouldFindShortestWordInFile() throws Exception {
        assertEquals("The shortest word must be 1", 1, FileStatistic.getFileShortest(lineStatisticListTest));
    }

    @Test
    public void shouldFindAverageWordInFile() throws Exception {
        assertEquals("The average word must be 4", 4, FileStatistic.getFileAvg(lineStatisticListTest));
    }

    @Test
    public void shouldFindFindAverageLineInFile() throws Exception {
        assertEquals("The average line must be 16", 16, FileStatistic.getFileAvgLine(lineStatisticListTest));
    }

    @Test
    public void shouldFindLongestWordInLine() throws Exception {
        String[] str = {"4444", "333", "1"};
        assertEquals("The longest word must be 4444", 4, LineStatistic.getLongest(str));
    }

    @Test
    public void shouldFindShortestWordInLine() throws Exception {
        String[] str = {"4444", "333", "1"};
        assertEquals("The shortest word must be 1", 1, LineStatistic.getShortest(str));
    }

}
