package com.luxoft.exone.database.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.luxoft.exone.database.jdbc.statisticbeans.LineStatistic;

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
