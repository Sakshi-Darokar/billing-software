package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Invoice;
import org.springframework.stereotype.Repository;
import java.util.*;

/*
 THIS IS INVOICE REPOSITORY CLASS.
 THIS CLASS HANDLES ALL DATABASE OPERATIONS RELATED TO INVOICE.

 FOR SIMPLICITY, WE ARE USING HASHMAP AS IN-MEMORY DATABASE.
 IN REAL PROJECT, THIS WILL BE REPLACED BY REAL DATABASE LIKE MYSQL.
*/

@Repository   // TELLS SPRING THIS CLASS IS A DATA ACCESS COMPONENT
public class InvoiceRepository {

    // HASHMAP USED AS TEMPORARY DATABASE STORAGE FOR INVOICES
    private Map<Long, Invoice> db = new HashMap<>();

    // AUTO GENERATED INVOICE NUMBER STARTING FROM 1001
    private long invoiceCounter = 1001;

    /*
     SAVE INVOICE INTO DATABASE
     AUTO GENERATE INVOICE NUMBER
     */
    public Invoice save(Invoice invoice) {
        invoice.setInvoiceId(invoiceCounter++);
        db.put(invoice.getInvoiceId(), invoice);
        return invoice;
    }

    /*
     FETCH ALL INVOICES FROM DATABASE
     */
    public List<Invoice> findAll() {
        return new ArrayList<>(db.values());
    }

    /*
     FETCH INVOICE BY INVOICE ID
     */
    public Optional<Invoice> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    /*
     FETCH ALL INVOICES OF A PARTICULAR CUSTOMER
     */
    public List<Invoice> findByCustomerId(Long customerId) {
        List<Invoice> list = new ArrayList<>();

        for (Invoice i : db.values()) {
            if (i.getCustomer().getId().equals(customerId)) {
                list.add(i);
            }
        }

        return list;
    }
}
