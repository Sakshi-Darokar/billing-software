package com.billing.billingsoftware.service;

import com.billing.billingsoftware.dto.InvoiceRequestDTO;
import com.billing.billingsoftware.entity.*;
import com.billing.billingsoftware.exception.*;
import com.billing.billingsoftware.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/*
 THIS IS INVOICE SERVICE CLASS.
 SERVICE LAYER CONTAINS COMPLETE BUSINESS LOGIC OF BILL GENERATION.

 CONTROLLER CALLS THIS CLASS.
 THIS CLASS VALIDATES DATA, PERFORMS CALCULATIONS,
 CHECKS STOCK, AND SAVES DATA USING REPOSITORY.
*/

@Service   // TELLS SPRING THIS CLASS CONTAINS BUSINESS LOGIC
public class InvoiceService {

    // REPOSITORY OBJECTS USED TO ACCESS DATABASE
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private final InvoiceRepository invoiceRepo;

    /*
     CONSTRUCTOR INJECTION
     SPRING WILL AUTOMATICALLY PROVIDE REPOSITORY OBJECTS
     */
    public InvoiceService(ProductRepository p, CustomerRepository c, InvoiceRepository i) {
        this.productRepo = p;
        this.customerRepo = c;
        this.invoiceRepo = i;
    }

    /*
     INVOICE GENERATION LOGIC

     STEP 1: ACCEPT CUSTOMER ID
     STEP 2: ACCEPT LIST OF PRODUCTS WITH QUANTITY
     STEP 3: FOR EACH PRODUCT
             - CALCULATE PRICE
             - CALCULATE GST
             - CHECK STOCK
     STEP 4: CALCULATE TOTAL AMOUNT, TAX, DISCOUNT AND FINAL AMOUNT
     STEP 5: SAVE INVOICE AND ITEMS INTO DATABASE
     */
    public Invoice generateInvoice(InvoiceRequestDTO dto) {

        // STEP 1: VALIDATE CUSTOMER USING CUSTOMER ID
        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        // LIST TO STORE ALL INVOICE ITEMS
        List<InvoiceItem> items = new ArrayList<>();

        // VARIABLES TO STORE TOTAL AMOUNT AND TOTAL TAX
        double totalAmount = 0;
        double totalTax = 0;

        // STEP 2: LOOP THROUGH ALL PRODUCTS RECEIVED FROM CLIENT
        for (InvoiceRequestDTO.Item item : dto.getItems()) {

            // STEP 3: FETCH PRODUCT USING PRODUCT ID
            Product product = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            // STEP 3.1: CHECK IF STOCK IS AVAILABLE
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock for " + product.getName());
            }

            // STEP 3.2: CALCULATE PRICE = PRODUCT PRICE × QUANTITY
            double price = product.getPrice() * item.getQuantity();

            // STEP 3.3: CALCULATE GST USING GST PERCENTAGE
            double tax = price * product.getGstPercentage() / 100;

            // STEP 3.4: CALCULATE TOTAL = PRICE + TAX
            double total = price + tax;

            // STEP 3.5: REDUCE PRODUCT STOCK AFTER BILLING
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepo.save(product);

            // STEP 3.6: CREATE INVOICE ITEM OBJECT
            InvoiceItem invoiceItem = new InvoiceItem(null, product, item.getQuantity(), price, tax, total);
            items.add(invoiceItem);

            // STEP 4: ADD VALUES TO TOTAL
            totalAmount += price;
            totalTax += tax;
        }

        // STEP 4.1: CREATE INVOICE OBJECT AND SET ALL VALUES
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setItems(items);
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setTotalAmount(totalAmount);        // SUBTOTAL
        invoice.setTotalTax(totalTax);              // TOTAL GST
        invoice.setDiscount(dto.getDiscount());     // DISCOUNT
        invoice.setFinalAmount(totalAmount + totalTax - dto.getDiscount()); // FINAL AMOUNT

        // STEP 5: SAVE INVOICE INTO DATABASE
        return invoiceRepo.save(invoice);
    }

    /*
     FETCH ALL INVOICES
     */
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    /*
     FETCH INVOICE BY INVOICE ID
     */
    public Invoice getInvoiceById(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
    }

    /*
     FETCH ALL INVOICES OF A PARTICULAR CUSTOMER
     */
    public List<Invoice> getInvoicesByCustomer(Long customerId) {
        return invoiceRepo.findByCustomerId(customerId);
    }
}
