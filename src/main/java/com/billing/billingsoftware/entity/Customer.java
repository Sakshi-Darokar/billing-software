package com.billing.billingsoftware.entity;

/*
 THIS IS CUSTOMER ENTITY CLASS.
 ENTITY REPRESENTS DATABASE TABLE STRUCTURE.

 THIS CLASS STORES CUSTOMER INFORMATION WHICH IS USED
 WHILE GENERATING INVOICE AND MANAGING CUSTOMER DATA.
*/

public class Customer {

    // UNIQUE ID FOR EACH CUSTOMER
    private Long id;

    // CUSTOMER NAME
    private String name;

    // CUSTOMER PHONE NUMBER
    private String phone;

    // CUSTOMER EMAIL ID
    private String email;

    // CUSTOMER ADDRESS
    private String address;

    /*
     DEFAULT CONSTRUCTOR
     REQUIRED BY SPRING AND FOR OBJECT CREATION
     */
    public Customer() {}

    /*
     PARAMETERIZED CONSTRUCTOR
     USED TO CREATE CUSTOMER OBJECT WITH ALL VALUES
     */
    public Customer(Long id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // GETTER AND SETTER FOR ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // GETTER AND SETTER FOR NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // GETTER AND SETTER FOR PHONE
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // GETTER AND SETTER FOR EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // GETTER AND SETTER FOR ADDRESS
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
