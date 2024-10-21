package com.pluarlsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SearchInventory {
    public static void main(String[] args) throws IOException {
        //intArrName.add(2);
        //stringArrName.set(0, "Bob");
        //.get();
        //.size();
        //.remove(); @ index
        //.clear(); removes A L L
        //Collections.sort(names);
        Product p = new Product(1, "Potatoes", 6);
        ArrayList<Product> names = new ArrayList<>();
        names.add(p);
        //Product p2 = new Product(1, "Potatoes", 6);
        p = new Product(2, "Peas", 4);
        names.add(p);

        String s1 = "4567|10' 2x4  (grade B)|9.99";
        String s2 = "1234|Hammer|19.49";
        String s3 = "2345|Box of nails|9.29";

        try(FileWriter writer = new FileWriter("inventory.csv", true)) {
            writer.write(s1 + "\n" + s2 + "\n" + s3 + "\n");
        }catch (IOException e) {
            e.printStackTrace();
            }

        /*try(FileReader reader = new FileReader("inventory.csv")) {
            int line = reader.read();
            while (line != -1) {*/
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String [] split = line.split("\\|");
                int id = Integer.parseInt(split[0]);
                String name = split[1];
                float price = Float.parseFloat(split[2]);
                Product pRead = new Product(id, name, price);
                names.add(pRead);
            }






        for (Product name : names){
            getInventory(name);
        }





        }





    }
    public static void getInventory (Product p) {
        System.out.println(p.toString());
    }
   /*public static  ArrayList<Product> getInventory () {
        return ;
   }*/
   /* public static  String getInventory (Product p) {
        return "Product ID: " + p.getId() + "\nProduct Name: \n" +  p.getName() + "Product Price: " + p.getPrice();
    }*/
}