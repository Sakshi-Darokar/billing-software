package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository 
public class CustomerRepository {

    private Map<Long, Customer> db = new HashMap<>();
    private long idCounter = 1;

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(idCounter++);
        }
        db.put(customer.getId(), customer);
        return customer;
    }

    
    public List<Customer> findAll() {
        return new ArrayList<>(db.values());
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }
}
