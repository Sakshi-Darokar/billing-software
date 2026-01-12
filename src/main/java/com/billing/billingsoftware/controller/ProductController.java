
package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.entity.Product;
import com.billing.billingsoftware.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 THIS CLASS IS A CONTROLLER CLASS.
 CONTROLLER LAYER IS RESPONSIBLE FOR HANDLING HTTP REQUESTS FROM CLIENT (POSTMAN / FRONTEND).
 IT RECEIVES REQUEST, CALLS SERVICE LAYER, AND RETURNS RESPONSE.
*/

@RestController                 // TELLS SPRING THIS IS A REST API CONTROLLER
@RequestMapping("/products")   // BASE URL FOR ALL PRODUCT APIS
public class ProductController {

    // SERVICE OBJECT TO ACCESS BUSINESS LOGIC
    private final ProductService service;

    // CONSTRUCTOR INJECTION - SPRING AUTOMATICALLY INJECTS ProductService OBJECT
    public ProductController(ProductService service) {
        this.service = service;
    }

    /*
     API: POST /products
     PURPOSE: ADD NEW PRODUCT
     REQUEST BODY: PRODUCT JSON
     */
    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

    /*
     API: GET /products
     PURPOSE: GET LIST OF ALL PRODUCTS
     */
    @GetMapping
    public List<Product> list() {
        return service.getAllProducts();
    }

    /*
     API: GET /products/{id}
     PURPOSE: GET PRODUCT BY ID
     */
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getProductById(id);
    }

    /*
     API: PUT /products/{id}
     PURPOSE: UPDATE PRODUCT DETAILS (PRICE, STOCK, NAME, GST)
     */
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    /*
     API: DELETE /products/{id}
     PURPOSE: DELETE PRODUCT BY ID
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return "PRODUCT DELETED SUCCESSFULLY";
    }
}

