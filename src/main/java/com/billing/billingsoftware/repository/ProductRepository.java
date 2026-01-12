package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

/*
 THIS IS PRODUCT REPOSITORY CLASS.
 THIS CLASS HANDLES ALL DATABASE OPERATIONS RELATED TO PRODUCTS.

 FOR SIMPLICITY, WE ARE USING HASHMAP AS IN-MEMORY DATABASE
 INSTEAD OF REAL DATABASE LIKE MYSQL.
*/

@Repository   // TELLS SPRING THIS CLASS IS A DATA ACCESS COMPONENT
public class ProductRepository {

    // HASHMAP USED AS TEMPORARY DATABASE STORAGE FOR PRODUCTS
    private Map<Long, Product> db = new HashMap<>();

    // AUTO INCREMENT ID COUNTER FOR PRODUCT
    private long idCounter = 1;

    /*
     SAVE PRODUCT INTO DATABASE
     IF ID IS NULL, AUTO GENERATE NEW PRODUCT ID
     */
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter++);
        }
        db.put(product.getId(), product);
        return product;
    }

    /*
     FETCH ALL PRODUCTS FROM DATABASE
     */
    public List<Product> findAll() {
        return new ArrayList<>(db.values());
    }

    /*
     FETCH PRODUCT BY PRODUCT ID
     */
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    /*
     DELETE PRODUCT FROM DATABASE USING PRODUCT ID
     */
    public void deleteById(Long id) {
        db.remove(id);
    }
}
