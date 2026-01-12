package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import com.billing.billingsoftware.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 THIS IS CUSTOMER SERVICE CLASS.
 SERVICE LAYER CONTAINS BUSINESS LOGIC.

 CONTROLLER CALLS THIS CLASS AND THIS CLASS
 COMMUNICATES WITH REPOSITORY FOR DATA OPERATIONS.
*/

@Service   // TELLS SPRING THIS CLASS CONTAINS BUSINESS LOGIC
public class CustomerService {

    // REPOSITORY OBJECT USED TO ACCESS CUSTOMER DATA
    private final CustomerRepository repo;

    /*
     CONSTRUCTOR INJECTION
     SPRING WILL AUTOMATICALLY PROVIDE CustomerRepository OBJECT
     */
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    /*
     ADD NEW CUSTOMER INTO DATABASE
     */
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    /*
     FETCH ALL CUSTOMERS FROM DATABASE
     */
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    /*
     FETCH CUSTOMER BY CUSTOMER ID
     IF CUSTOMER NOT FOUND, THROW CUSTOM EXCEPTION
     */
    public Customer getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}
