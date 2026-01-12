package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 THIS IS CUSTOMER CONTROLLER CLASS.
 CONTROLLER LAYER HANDLES ALL HTTP REQUESTS RELATED TO CUSTOMER.
 IT RECEIVES REQUEST FROM CLIENT (POSTMAN / FRONTEND),
 CALLS SERVICE LAYER FOR BUSINESS LOGIC,
 AND RETURNS RESPONSE BACK TO CLIENT.
*/

@RestController                 // TELLS SPRING THIS CLASS IS A REST CONTROLLER
@RequestMapping("/customers")  // BASE URL FOR ALL CUSTOMER APIS
public class CustomerController {

    // SERVICE OBJECT USED TO CALL CUSTOMER BUSINESS LOGIC
    private final CustomerService service;

    // CONSTRUCTOR INJECTION - SPRING WILL AUTO-INJECT CustomerService OBJECT
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /*
     API: POST /customers
     PURPOSE: ADD NEW CUSTOMER
     REQUEST BODY: CUSTOMER JSON DATA
     */
    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    /*
     API: GET /customers
     PURPOSE: FETCH LIST OF ALL CUSTOMERS
     */
    @GetMapping
    public List<Customer> list() {
        return service.getAllCustomers();
    }

    /*
     API: GET /customers/{id}
     PURPOSE: FETCH CUSTOMER DETAILS BY ID
     */
    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return service.getCustomerById(id);
    }
}
