package com.billing.billingsoftware.dto;

import java.util.List;

/*
 THIS IS INVOICE REQUEST DTO CLASS.
 DTO STANDS FOR DATA TRANSFER OBJECT.
 THIS CLASS IS USED TO RECEIVE BILLING DATA FROM CLIENT (POSTMAN / FRONTEND).

 IT CONTAINS:
 1. CUSTOMER ID
 2. LIST OF PRODUCTS WITH QUANTITY
 3. DISCOUNT VALUE

 THIS DTO IS USED WHILE CREATING A NEW INVOICE.
*/

public class InvoiceRequestDTO {

    // STORES CUSTOMER ID FOR WHICH BILL IS GENERATED
    private Long customerId;

    // STORES LIST OF PRODUCTS AND THEIR QUANTITY
    private List<Item> items;

    // STORES DISCOUNT VALUE (OPTIONAL)
    private double discount;

    /*
     INNER CLASS Item
     THIS CLASS STORES PRODUCT ID AND QUANTITY
     USED FOR EACH PRODUCT IN BILL
     */
    public static class Item {

        // PRODUCT ID SELECTED FOR BILLING
        private Long productId;

        // QUANTITY OF PRODUCT
        private int quantity;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // GETTER AND SETTER FOR CUSTOMER ID
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    // GETTER AND SETTER FOR PRODUCT ITEMS LIST
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // GETTER AND SETTER FOR DISCOUNT
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
