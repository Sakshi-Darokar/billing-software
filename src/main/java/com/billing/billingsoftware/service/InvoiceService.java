package com.billing.billingsoftware.service;

import com.billing.billingsoftware.dto.InvoiceRequestDTO;
import com.billing.billingsoftware.entity.*;
import com.billing.billingsoftware.exception.*;
import com.billing.billingsoftware.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service  
public class InvoiceService {

    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private final InvoiceRepository invoiceRepo;

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

       
        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        List<InvoiceItem> items = new ArrayList<>();

        double totalAmount = 0;
        double totalTax = 0;

        for (InvoiceRequestDTO.Item item : dto.getItems()) {

            
            Product product = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            if (product.getStockQuantity() < item.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock for " + product.getName());
            }

            double price = product.getPrice() * item.getQuantity();
            double tax = price * product.getGstPercentage() / 100;

            double total = price + tax;

            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepo.save(product);

            InvoiceItem invoiceItem = new InvoiceItem(null, product, item.getQuantity(), price, tax, total);
            items.add(invoiceItem);

            totalAmount += price;
            totalTax += tax;
        }

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setItems(items);
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setTotalAmount(totalAmount);        // SUBTOTAL
        invoice.setTotalTax(totalTax);              // TOTAL GST
        invoice.setDiscount(dto.getDiscount());     // DISCOUNT
        invoice.setFinalAmount(totalAmount + totalTax - dto.getDiscount()); // FINAL AMOUNT

        return invoiceRepo.save(invoice);
    }


    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
    }

    public List<Invoice> getInvoicesByCustomer(Long customerId) {
        return invoiceRepo.findByCustomerId(customerId);
    }
}
