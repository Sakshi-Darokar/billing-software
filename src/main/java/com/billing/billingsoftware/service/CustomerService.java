package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Customer;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import com.billing.billingsoftware.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class CustomerService {

    private final CustomerRepository repo;
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }
 
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}
