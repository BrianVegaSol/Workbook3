package com.pluarlsight;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product() {}

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public String toString () {
        return "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Price: $" + getPrice() + "\n" +
                "-----------------------------";
    }

    public static String mapString(HashMap<Integer, Product> map){
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
            sb.append("ID: ").append(entry.getKey())
                    .append("\nName: ").append(entry.getValue().getName())
            .append(String.format("\nPrice: $%.2f", (entry.getValue().getPrice())))
            .append("\n-----------------------------\n");
        }

        /*sb.append("ID: ").append(map.get().getId());
        sb.append("\nName: ").append(map.get().getName());
        sb.append("\nPrice: ").append(map.get().getPrice());
        sb.append("-----------------------------");*/
        return sb.toString();
    }

}
