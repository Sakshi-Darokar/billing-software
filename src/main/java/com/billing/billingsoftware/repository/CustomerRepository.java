package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
import org.springframework.stereotype.Repository;
import java.util.*;

/*
 THIS IS CUSTOMER REPOSITORY CLASS.
 REPOSITORY LAYER IS RESPONSIBLE FOR DATA STORAGE OPERATIONS.

 IN THIS PROJECT WE ARE USING IN-MEMORY DATABASE (HASHMAP)
 INSTEAD OF REAL DATABASE FOR SIMPLICITY.
*/

@Repository   // TELLS SPRING THIS CLASS IS A DATA ACCESS COMPONENT
public class CustomerRepository {

    // HASHMAP USED AS TEMPORARY DATABASE STORAGE
    private Map<Long, Customer> db = new HashMap<>();

    // AUTO INCREMENT ID COUNTER FOR CUSTOMER
    private long idCounter = 1;

    /*
     SAVE CUSTOMER INTO DATABASE
     IF ID IS NULL, AUTO GENERATE NEW ID
     */
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(idCounter++);
        }
        db.put(customer.getId(), customer);
        return customer;
    }

    /*
     FETCH ALL CUSTOMERS FROM DATABASE
     */
    public List<Customer> findAll() {
        return new ArrayList<>(db.values());
    }

    /*
     FETCH CUSTOMER BY ID
     RETURNS OPTIONAL TO HANDLE NULL SAFELY
     */
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }
}
