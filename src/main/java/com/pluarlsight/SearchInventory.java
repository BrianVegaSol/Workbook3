package com.pluarlsight;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SearchInventory {
    public static void main(String[] args) {
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

        for (Product name : names){
            getInventory(name);
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