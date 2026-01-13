package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.dto.InvoiceRequestDTO;
import com.billing.billingsoftware.entity.Invoice;
import com.billing.billingsoftware.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController                  
@RequestMapping("/invoices")    
public class InvoiceController {

  
    private final InvoiceService service;

   
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

   
    @PostMapping
    public Invoice create(@RequestBody InvoiceRequestDTO dto) {
        return service.generateInvoice(dto);
    }

    
    @GetMapping
    public List<Invoice> list() {
        return service.getAllInvoices();
    }

   
    @GetMapping("/{id}")
    public Invoice get(@PathVariable Long id) {
        return service.getInvoiceById(id);
    }

   
    @GetMapping("/customer/{customerId}")
    public List<Invoice> byCustomer(@PathVariable Long customerId) {
        return service.getInvoicesByCustomer(customerId);
    }
}
