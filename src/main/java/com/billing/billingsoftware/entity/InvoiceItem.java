package com.billing.billingsoftware.entity;

public class InvoiceItem {

    private Long id;
    private Product product;
    private int quantity;
    private double price;
    private double taxAmount;
    private double total;
    public InvoiceItem() {}
    public InvoiceItem(Long id, Product product, int quantity, double price, double taxAmount, double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
