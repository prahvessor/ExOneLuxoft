package com.luxoft.exone.database.jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.luxoft.exone.database.jdbc.statisticbeans.FileStatistic;
import com.luxoft.exone.database.jdbc.statisticbeans.LineStatistic;

public class FileStatisticTest {
    
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
        assertEquals(9, FileStatistic.findFileLongest(lineStatisticListTest));
    }

    @Test
    public void shouldFindShortestWordInFile() throws Exception {
        assertEquals(1, FileStatistic.findFileShortest(lineStatisticListTest));
    }

    @Test
    public void shouldFindAverageWordInFile() throws Exception {
        assertEquals(4, FileStatistic.findFileAvg(lineStatisticListTest));
    }

    @Test
    public void shouldFindFindAverageLineInFile() throws Exception {
        assertEquals(16, FileStatistic.findFileAvgLine(lineStatisticListTest));
    }

}
