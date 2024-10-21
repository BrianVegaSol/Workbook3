package com.pluarlsight;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}