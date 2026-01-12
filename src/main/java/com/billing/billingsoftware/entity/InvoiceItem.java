package com.billing.billingsoftware.entity;

/*
 THIS IS INVOICE ITEM ENTITY CLASS.
 THIS CLASS REPRESENTS EACH PRODUCT ENTRY INSIDE AN INVOICE.

 ONE INVOICE CAN HAVE MULTIPLE INVOICE ITEMS.
 EACH INVOICE ITEM STORES PRODUCT DETAILS, QUANTITY, PRICE, TAX AND TOTAL.
*/

public class InvoiceItem {

    // UNIQUE ID FOR EACH INVOICE ITEM
    private Long id;

    // PRODUCT DETAILS FOR THIS ITEM
    private Product product;

    // QUANTITY OF PRODUCT PURCHASED
    private int quantity;

    // PRICE WITHOUT TAX (PRICE = PRODUCT PRICE × QUANTITY)
    private double price;

    // TAX AMOUNT FOR THIS PRODUCT
    private double taxAmount;

    // TOTAL AMOUNT (PRICE + TAX)
    private double total;

    /*
     DEFAULT CONSTRUCTOR
     REQUIRED BY SPRING FOR OBJECT CREATION
     */
    public InvoiceItem() {}

    /*
     PARAMETERIZED CONSTRUCTOR
     USED TO CREATE INVOICE ITEM OBJECT WITH ALL VALUES
     */
    public InvoiceItem(Long id, Product product, int quantity, double price, double taxAmount, double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
        this.total = total;
    }

    // GETTER AND SETTER FOR ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // GETTER AND SETTER FOR PRODUCT
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // GETTER AND SETTER FOR QUANTITY
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // GETTER AND SETTER FOR PRICE
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // GETTER AND SETTER FOR TAX AMOUNT
    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    // GETTER AND SETTER FOR TOTAL AMOUNT
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
