package com.pluarlsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("src/example.txt"); //make sure spelling is correct :/
            Scanner scan = new Scanner(file);// This will throw FileNotFoundException
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found");
            //throw new FileNotFoundException(e);
        }

        // The file to write the data
        String fileName = "dbz_powerlevels.txt";
        // Array of characters and their power levels
        String[] characters = {
                "Goku: 9000",
                "Vegeta: 8500",
                "Piccolo: 7000",
                "Gohan: 6000",
                "Frieza: 12000",
                "Cell: 15000",
                "Majin Buu: 20000"
        };
        // Try-with-resources to ensure the file is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write each character and their power level to the file
            for (String character : characters) {
                writer.write(character);
             writer.newLine();
            // Move to the next line
            } System.out.println("File written successfully.");
    } catch (IOException e) {
        System.err.println("An error occurred while writing to the file.");
        e.printStackTrace(); }


    }
}