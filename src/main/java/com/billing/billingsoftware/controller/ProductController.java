
package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController                 
@RequestMapping("/products")   
public class ProductController {

   
    private final ProductService service;

    
    public ProductController(ProductService service) {
        this.service = service;
    }

   
    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

   
    @GetMapping
    public List<Product> list() {
        return service.getAllProducts();
    }

    
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getProductById(id);
    }

 
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return "PRODUCT DELETED SUCCESSFULLY";
    }
}

