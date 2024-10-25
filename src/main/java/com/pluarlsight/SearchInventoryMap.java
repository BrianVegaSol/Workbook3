package com.pluarlsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {
    static Scanner scan = new Scanner(System.in);
    static boolean runMenu = true;

    public static void main(String[] args) {
        //HashMap fast loopup since computer decides the fastest way to store items
        //.put(key, value);
        //.get(key); outputs value
        //.remove(key)
        //.clear() remove ALL
        //.values() or .keySet()
        // for (String value : statesAndCapitals.values()) {
        //   System.out.println(value); }

        /*HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
            System.out.print("The capital of Oklahoma is: ");
            String value = statesAndCapitals.get("OK");
            if (value != null) {
               System.out.println(value);
            }  else {
               System.out.println("OK is not in the states map");
            };*/
        menu();

    }

    public static void menu() {
        while (runMenu) {
            System.out.println("What do you want to do? \n" +
                    "1-\tList all products \n" +
                    "2-\tLookup a product by its id \n" +
                    "3-\tFind all products within a price range \n" +
                    "4-\tAdd a new product \n" +
                    "5-\tQuit the application Enter command:");
            int input = scan.nextInt();
            switch (input) {
                case 5:
                    System.out.println("Goodbye");
                    runMenu = false;
                    break;
                case 1:
                    allProducts();
                    break;
                case 2:
                    searchByID();
                    break;
                case 3:
                    searchByPrice();
                    break;
                case 4:
                    addProduct();
                    break;
            }

        }
    }
    public static void allProducts () {

    }
    public static void searchByID () {

    }
    public static void searchByPrice () {

    }
    public static void addProduct () {
        String file = "inventory.csv";
        System.out.println("Enter the new product as follows:\n" +
                "ID|Description|Price");
        scan.nextLine();
        String input = scan.nextLine();
        try(FileWriter write = new FileWriter(file, true)){
            write.write(input.trim() + "\n");
        } catch (IOException e) {
            System.err.println("Error occurred" + e.getMessage());
        }
    }


}
