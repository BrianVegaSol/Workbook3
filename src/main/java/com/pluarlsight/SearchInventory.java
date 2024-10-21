package com.pluarlsight;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.*;
import java.util.List;

public class SearchInventory {
    static Scanner scan = new Scanner(System.in);
    static boolean runMenu = true;
    static int input;
    static ArrayList<Product> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //intArrName.add(2);
        //stringArrName.set(0, "Bob");
        //.get();
        //.size();
        //.remove(); @ index
        //.clear(); removes A L L
        //Collections.sort(names);
        Product p = new Product(1, "Potatoes", 6);

        names.add(p);
        //Product p2 = new Product(1, "Potatoes", 6);
        p = new Product(2, "Peas", 4);
        names.add(p);

        String s1 = "4567|10' 2x4  (grade B)|9.99";
        String s2 = "1234|Hammer|19.49";
        String s3 = "2345|Box of nails|9.29";
        menu();


        /*try(FileReader reader = new FileReader("inventory.csv")) {
            int line = reader.read();
            while (line != -1) {*/



    }

    public static void getInventory(Product p) {
        System.out.println(p.toString());
    }

    public static void menu() {
        while (runMenu) {
            System.out.println("What do you want to do? \n" +
                    "1-\tList all products \n" +
                    "2-\tLookup a product by its id \n" +
                    "3-\tFind all products within a price range \n" +
                    "4-\tAdd a new product \n" +
                    "5-\tQuit the application Enter command:");
            input = scan.nextInt();
            switch (input) {
                case 5:
                    runMenu = false;
                    System.out.println("Shutting down . . .");
                    scan.close();
                    break;
                case 1:
                    reader();
                        Collections.sort(names, (c1,c2) -> Integer.compare(c1.getId(), c2.getId()));
                    for (Product name : names) {
                        //Collections.reverse(names.get(i).getId());
                        //Collections.sort(names, Comparator.comparingInt(Product::getId));
                        getInventory(name);
                    }
                    break;
                case 2:
                    reader();
                    searchID();
                    break;
                case 3:

                    break;
                case 4:
                    writer();
                    break;

            }
        }
    }

    public static void searchID() {
        System.out.print("Enter the ID: ");
        int search = scan.nextInt();
        for (Product prod : names)
            if (prod.getId() == search) {
                System.out.println(prod);
            }
    }

    public static void writer () {
        System.out.println("Add your Product Info: id|name|price");
        Scanner scanner = new Scanner(System.in);
        String newProduct = scanner.nextLine();
        String file = "inventory.csv";
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(newProduct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reader () {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                int id = Integer.parseInt(split[0]);
                String name = split[1];
                float price = Float.parseFloat(split[2]);
                Product pRead = new Product(id, name, price);
                names.add(pRead);
            }
            /*for (Product name : names) {
                getInventory(name);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /*public static  ArrayList<Product> getInventory () {
        return ;
   }*/
   /* public static  String getInventory (Product p) {
        return "Product ID: " + p.getId() + "\nProduct Name: \n" +  p.getName() + "Product Price: " + p.getPrice();
    }*/
}
