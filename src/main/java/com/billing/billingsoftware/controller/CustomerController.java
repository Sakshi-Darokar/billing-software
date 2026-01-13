package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController                
@RequestMapping("/customers") 
public class CustomerController {

    // SERVICE OBJECT USED TO CALL CUSTOMER BUSINESS LOGIC
    private final CustomerService service;

    // CONSTRUCTOR INJECTION - SPRING WILL AUTO-INJECT CustomerService OBJECT
    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

  
    @GetMapping
    public List<Customer> list() {
        return service.getAllCustomers();
    }

   
    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return service.getCustomerById(id);
    }
}
