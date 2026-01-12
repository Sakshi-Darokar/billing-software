package com.billing.billingsoftware.entity;

/*
 THIS IS PRODUCT ENTITY CLASS.
 ENTITY REPRESENTS DATABASE TABLE STRUCTURE.

 THIS CLASS STORES PRODUCT INFORMATION WHICH IS USED
 FOR INVENTORY MANAGEMENT AND BILLING PROCESS.
*/

public class Product {

    // UNIQUE ID FOR EACH PRODUCT
    private Long id;

    // PRODUCT NAME
    private String name;

    // PRODUCT PRICE (WITHOUT TAX)
    private double price;

    // GST PERCENTAGE APPLIED ON PRODUCT
    private double gstPercentage;

    // AVAILABLE STOCK QUANTITY
    private int stockQuantity;

    /*
     DEFAULT CONSTRUCTOR
     REQUIRED BY SPRING FOR OBJECT CREATION
     */
    public Product() {}

    /*
     PARAMETERIZED CONSTRUCTOR
     USED TO CREATE PRODUCT OBJECT WITH ALL VALUES
     */
    public Product(Long id, String name, double price, double gstPercentage, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.gstPercentage = gstPercentage;
        this.stockQuantity = stockQuantity;
    }

    // GETTER AND SETTER FOR PRODUCT ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // GETTER AND SETTER FOR PRODUCT NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // GETTER AND SETTER FOR PRODUCT PRICE
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // GETTER AND SETTER FOR GST PERCENTAGE
    public double getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(double gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    // GETTER AND SETTER FOR STOCK QUANTITY
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
