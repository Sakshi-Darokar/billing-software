package com.billing.billingsoftware.dto;

import java.time.LocalDateTime;
import java.util.List;

/*
 THIS IS INVOICE RESPONSE DTO CLASS.
 THIS DTO IS USED TO SEND COMPLETE INVOICE DETAILS BACK TO CLIENT.

 IT CONTAINS:
 1. INVOICE ID AND DATE
 2. CUSTOMER DETAILS
 3. PRODUCT LIST WITH PRICE, TAX AND TOTAL
 4. TOTAL AMOUNT, TAX, DISCOUNT AND FINAL PAYABLE AMOUNT
*/

public class InvoiceResponseDTO {

    // STORES AUTO GENERATED INVOICE ID
    private Long invoiceId;

    // STORES DATE AND TIME OF INVOICE GENERATION
    private LocalDateTime invoiceDate;

    // STORES CUSTOMER NAME
    private String customerName;

    // STORES CUSTOMER PHONE NUMBER
    private String customerPhone;

    // STORES LIST OF PRODUCTS INCLUDED IN INVOICE
    private List<Item> items;

    // STORES SUBTOTAL AMOUNT (WITHOUT TAX)
    private double totalAmount;

    // STORES TOTAL GST AMOUNT
    private double totalTax;

    // STORES DISCOUNT VALUE
    private double discount;

    // STORES FINAL PAYABLE AMOUNT AFTER TAX AND DISCOUNT
    private double finalAmount;

    /*
     INNER ITEM DTO
     THIS CLASS STORES EACH PRODUCT DETAILS IN INVOICE
     */
    public static class Item {

        // PRODUCT NAME
        private String productName;

        // PRODUCT QUANTITY
        private int quantity;

        // PRICE WITHOUT TAX
        private double price;

        // TAX AMOUNT FOR THIS PRODUCT
        private double taxAmount;

        // TOTAL PRICE (PRICE + TAX)
        private double total;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
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

    // -------- GETTERS AND SETTERS --------

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
