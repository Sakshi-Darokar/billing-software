package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Invoice;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class InvoiceRepository {

    private Map<Long, Invoice> db = new HashMap<>();
    private long invoiceCounter = 1001;
    public Invoice save(Invoice invoice) {
        invoice.setInvoiceId(invoiceCounter++);
        db.put(invoice.getInvoiceId(), invoice);
        return invoice;
    }

    public List<Invoice> findAll() {
        return new ArrayList<>(db.values());
    }

    public Optional<Invoice> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }
 
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
