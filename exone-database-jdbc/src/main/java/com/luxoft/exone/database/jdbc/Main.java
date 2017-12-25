package com.luxoft.exone.database.jdbc;

import com.luxoft.exone.database.jdbc.dbutils.TableUpdater;
import com.luxoft.exone.database.jdbc.statisticbeans.FileStatistic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    private static List<List> listOfFiles = new ArrayList<>();
    private static List<FileStatistic> fileStatisticList = new ArrayList<>();

    public static void main( String[] args ) {
        
        final String FILE_PATH = "src/main/resources";
        
        System.out.println("Program started");
        
        final File folder = new File(FILE_PATH);
        
        getListOfFilesFromFolder(folder);
        
        for (List<String> flist : listOfFiles) {
            fileStatisticList.add(new FileStatistic(flist));
        }
        
        TableUpdater tableUpdater = new TableUpdater();
        tableUpdater.updateTable(fileStatisticList);
        
        System.out.println("Program completed. Check the DB please");
    }
    
    public static void getListOfFilesFromFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getListOfFilesFromFolder(fileEntry);
            } else {
                
                List<String> listOfLines = new ArrayList<>();
                try (BufferedReader input = new BufferedReader(new FileReader(fileEntry))){
                    String line;
                    while ((line = input.readLine()) != null)
                        listOfLines.add(line);
                }catch (IOException e) {
                    e.printStackTrace();
                }
                listOfFiles.add(listOfLines);
            }
        }
    }
}
