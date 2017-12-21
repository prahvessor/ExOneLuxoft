package com.luxoft.exone.exone_database_jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    private static List<String> listOfLines = new ArrayList<>();
    
    public static void main( String[] args ) {
        
        final String FILE_PATH = "src/main/resources/test_text.txt";
        
        System.out.println("Program started");
        
        List<String> listOfLines = getListOfLinesFromFile(FILE_PATH);
        
        System.out.println("Program completed. Check the DB please");
    }
    public static List<String> getListOfLinesFromFile(String filePath) {
        
        List<String> listOfLines = new ArrayList<>();
        
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = input.readLine()) != null)
                listOfLines.add(line);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return listOfLines;
    }
}
