package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import com.billing.billingsoftware.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 THIS IS PRODUCT SERVICE CLASS.
 SERVICE LAYER CONTAINS BUSINESS LOGIC RELATED TO PRODUCTS.

 CONTROLLER CALLS THIS CLASS.
 THIS CLASS COMMUNICATES WITH REPOSITORY TO SAVE AND FETCH DATA.
*/

@Service   // TELLS SPRING THIS CLASS IS A SERVICE LAYER COMPONENT
public class ProductService {

    // REPOSITORY OBJECT USED TO ACCESS PRODUCT DATA
    private final ProductRepository repo;

    /*
     CONSTRUCTOR INJECTION
     SPRING WILL AUTOMATICALLY PROVIDE PRODUCT REPOSITORY OBJECT
     */
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    /*
     ADD NEW PRODUCT INTO DATABASE
     */
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    /*
     UPDATE EXISTING PRODUCT DETAILS USING PRODUCT ID
     */
    public Product updateProduct(Long id, Product product) {

        // CHECK IF PRODUCT EXISTS
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // UPDATE PRODUCT DETAILS
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setGstPercentage(product.getGstPercentage());
        existing.setStockQuantity(product.getStockQuantity());

        // SAVE UPDATED PRODUCT
        return repo.save(existing);
    }

    /*
     FETCH ALL PRODUCTS FROM DATABASE
     */
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    /*
     FETCH SINGLE PRODUCT USING PRODUCT ID
     */
    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    /*
     DELETE PRODUCT USING PRODUCT ID
     */
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
