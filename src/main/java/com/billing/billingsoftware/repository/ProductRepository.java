package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {

    private Map<Long, Product> db = new HashMap<>();
    private long idCounter = 1;
 
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter++);
        }
        db.put(product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(db.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public void deleteById(Long id) {
        db.remove(id);
    }
}
