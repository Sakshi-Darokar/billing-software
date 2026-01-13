package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.exception.ResourceNotFoundException;
import com.billing.billingsoftware.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class ProductService {
 
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(Long id, Product product) {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setGstPercentage(product.getGstPercentage());
        existing.setStockQuantity(product.getStockQuantity());

        return repo.save(existing);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
