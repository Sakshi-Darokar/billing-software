package com.billing.billingsoftware.entity;

import java.time.LocalDateTime;
import java.util.List;

/*
 THIS IS INVOICE ENTITY CLASS.
 THIS CLASS REPRESENTS THE INVOICE TABLE STRUCTURE.

 IT STORES COMPLETE BILL INFORMATION LIKE:
 CUSTOMER DETAILS, PRODUCT LIST, TOTAL AMOUNT, TAX, DISCOUNT AND FINAL AMOUNT.
*/

public class Invoice {

    // AUTO GENERATED UNIQUE INVOICE NUMBER
    private Long invoiceId;

    // DATE AND TIME WHEN INVOICE IS GENERATED
    private LocalDateTime invoiceDate;

    // CUSTOMER FOR WHOM THIS INVOICE IS GENERATED
    private Customer customer;

    // LIST OF PRODUCTS INCLUDED IN THIS INVOICE
    private List<InvoiceItem> items;

    // TOTAL AMOUNT WITHOUT TAX
    private double totalAmount;

    // TOTAL GST AMOUNT
    private double totalTax;

    // DISCOUNT APPLIED ON BILL
    private double discount;

    // FINAL PAYABLE AMOUNT (TOTAL + TAX - DISCOUNT)
    private double finalAmount;

    /*
     DEFAULT CONSTRUCTOR
     REQUIRED BY SPRING FOR OBJECT CREATION
     */
    public Invoice() {}

    // GETTER AND SETTER FOR INVOICE ID
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    // GETTER AND SETTER FOR INVOICE DATE
    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    // GETTER AND SETTER FOR CUSTOMER
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // GETTER AND SETTER FOR INVOICE ITEMS
    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    // GETTER AND SETTER FOR TOTAL AMOUNT
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // GETTER AND SETTER FOR TOTAL TAX
    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    // GETTER AND SETTER FOR DISCOUNT
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // GETTER AND SETTER FOR FINAL PAYABLE AMOUNT
    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
