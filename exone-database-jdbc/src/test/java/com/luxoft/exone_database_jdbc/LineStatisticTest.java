package com.luxoft.exone_database_jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.luxoft.exone_database_jdbc.statisticbeans.LineStatistic;

public class LineStatisticTest {

    public static String[] str = {"4444", "333", "1"};
    
    @Test
    public void shouldFindLongestWordInLine() throws Exception {
        assertEquals(4, LineStatistic.findLongest(str));
    }

    @Test
    public void shouldFindShortestWordInLine() throws Exception {
        assertEquals(1, LineStatistic.findShortest(str));
    }

}
