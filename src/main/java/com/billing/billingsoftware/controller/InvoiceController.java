package com.billing.billingsoftware.controller;

import com.billing.billingsoftware.dto.InvoiceRequestDTO;
import com.billing.billingsoftware.entity.Invoice;
import com.billing.billingsoftware.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 THIS IS INVOICE CONTROLLER CLASS.
 THIS CLASS HANDLES ALL BILLING AND INVOICE RELATED HTTP REQUESTS.
 IT RECEIVES REQUEST FROM CLIENT (POSTMAN / FRONTEND),
 CALLS SERVICE LAYER FOR BILL GENERATION LOGIC,
 AND RETURNS RESPONSE BACK TO CLIENT.
*/

@RestController                  // TELLS SPRING THIS CLASS IS A REST CONTROLLER
@RequestMapping("/invoices")    // BASE URL FOR ALL INVOICE APIS
public class InvoiceController {

    // SERVICE OBJECT USED TO CALL INVOICE BUSINESS LOGIC
    private final InvoiceService service;

    // CONSTRUCTOR INJECTION - SPRING WILL AUTO-INJECT InvoiceService OBJECT
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    /*
     API: POST /invoices
     PURPOSE: CREATE NEW INVOICE / GENERATE BILL
     REQUEST BODY: CUSTOMER ID, PRODUCT LIST AND DISCOUNT
     */
    @PostMapping
    public Invoice create(@RequestBody InvoiceRequestDTO dto) {
        return service.generateInvoice(dto);
    }

    /*
     API: GET /invoices
     PURPOSE: FETCH LIST OF ALL INVOICES
     */
    @GetMapping
    public List<Invoice> list() {
        return service.getAllInvoices();
    }

    /*
     API: GET /invoices/{id}
     PURPOSE: FETCH INVOICE DETAILS BY INVOICE ID
     */
    @GetMapping("/{id}")
    public Invoice get(@PathVariable Long id) {
        return service.getInvoiceById(id);
    }

    /*
     API: GET /invoices/customer/{customerId}
     PURPOSE: FETCH ALL INVOICES OF A PARTICULAR CUSTOMER
     */
    @GetMapping("/customer/{customerId}")
    public List<Invoice> byCustomer(@PathVariable Long customerId) {
        return service.getInvoicesByCustomer(customerId);
    }
}
