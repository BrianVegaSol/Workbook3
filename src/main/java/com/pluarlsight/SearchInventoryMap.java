package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

public class SearchInventoryMap {
    static Scanner scan = new Scanner(System.in);
    static boolean runMenu = true;
    static HashMap<Integer, Product> product;

    public static String toStringy(Product prod) {
        return "ID: " + prod.getId() + "\n" +
                "Name: " + prod.getName() + "\n" +
                "Price: $" + prod.getPrice() + "\n" +
                "-----------------------------";
    }

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
        reader();
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

    //Sorts from newest to oldest
    public static void allProducts() {
        product.forEach((k, v) -> {
            System.out.print(Product.mapString(k, v.getName(), v.getPrice()));
        });
        //Print w/o order
        /*var printMap = product.entrySet();
        for (var entry : printMap) {
            System.out.println(entry);*/

        //Proving this can be done :')
        /*product.forEach((k, v) -> {
            System.out.println("ID: " + k +
                    String.format("\nName: %s%nPrice: $%.2f",v.getName(),v.getPrice()));
        });*/


        /*for (int i = 0; i <= product.size(); i++) {
        }*/
        //System.out.println(Product.mapString(product)); Old Code
    }

    public static void searchByID() {
        for (int id : product.keySet()) {

            //product.sort(Map.Entry.comparingByKey());

            System.out.println(toStringy(product.get(0)));
        }
        for (int i = 0; i < product.size(); i++) {
            int j = 1;
            Map.Entry.comparingByKey();
            //if (Integer.parseInt(String.valueOf(product.get(i))) <=  Integer.parseInt(String.valueOf(product.get(j)))) {
            //if (product.containsKey(i) < product.keySet(). {
            //Integer.compare(product.get(i),product.get(j));
            System.out.println(product.keySet());
            // }
            //j++;
        }

    }

    public static void searchByPrice() {

    }


    public static void addProduct() {
        String file = "inventory.csv";
        String input = "";
        int id = -1;
        try {
            System.out.println("Enter the new product as follows:\n" +
                    "ID|Description|Price");
            scan.nextLine();
            input = scan.nextLine();
            String[] split = input.split("\\|");
            id = Integer.parseInt(split[0]);
            //if (product.putIfAbsent(id,values) != null)
            if (product.get(id).getId() == id) {
                throw new IllegalArgumentException("Unable to add new product, duplicate id for: " + id);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Unable to add new product, duplicate id for: " + id);
            return;
        }


        try (FileWriter write = new FileWriter(file, true)) {
            write.write(input.trim() + "\n");
        } catch (IOException e) {
            System.err.println("Error occurred" + e.getMessage());
        }
    }

    public static void reader() {
        String file = "inventory.csv";
        product = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                int id = Integer.parseInt(split[0]);
                String name = split[1];
                float price = Float.parseFloat(split[2]);
                Product pRead = new Product(name, price);
                pRead.setId(id);

                product.put(id, pRead);
                //System.out.println(toStringy(pRead));
            }
            /*for (Product name : names) {
                getInventory(name);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
