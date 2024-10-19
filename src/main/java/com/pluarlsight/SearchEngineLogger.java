package com.pluarlsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchEngineLogger {
    static boolean searchAgain = true;
    //static int startAppCounter = 0;
    static boolean exitApp = false;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //counter/boolean for tracking startup/search/exit
        //switch menu?
        //always have startup++
        //then go to switch menu
        //search / exit
        //in writeToLog() keep track of all counters
        //in case exit: writeToLog(), then break/return;
        //method to write to log.txt, WITHOUT OVERWRITING THE REST OF THE DATA
        String launch = "launch";
        writeToLog(launch);
        do {
            System.out.println("Welcome!\nWhat would you like to do?\n1) Search\n0) Exit");
            int input = scan.nextByte();
                switch (input) {
                    //Exit app
                    case 0:
                        exitApp();
                        exitApp = true;
                        break;
                    case 1:
                        //search();
                        writeToLog(search());
                        System.out.println("Would you like to search again? (y/n)");
                        char response = scan.next().charAt(0);
                        while (Character.toUpperCase(response) == 'Y') {
                                writeToLog(search());
                            System.out.println("Would you like to search again? (y/n)");
                            response = scan.next().charAt(0);

                        }
                            exitApp();
                            exitApp = true;
                        }
                        break;
        } while (!exitApp);
        scan.close();

    }

    /*public static void writeToLo(String search) {
        //Write LocalDateTime now
        //Write what was searched ArrayList .add()
        //Write counters to log
        System.out.println("What would you like to search?");
        String searchText = scan.nextLine();

    }*/

    public static String search() {
        System.out.println("Enter a search term\n(0 to exit)");
        Scanner scanner = new Scanner(System.in);
        String searchText = scanner.nextLine();
        return "search : " + searchText;
    }

    public static void writeToLog(String info) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
            String formDateTime = dateTime.format(formatter);
            writer.write(formDateTime + " " + info + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exitApp() {
        System.out.println("Exiting...");
        String exitLog = "exit";
        writeToLog(exitLog);
    }
}
