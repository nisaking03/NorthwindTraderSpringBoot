package com.pluralsight.NorthwindTraderSpringBoot.Models;

public class Product {

    private int products;
    private String name;
    private String category;
    private double price;

    public Product(int products, String name, String category, double price) {
        this.products = products;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
