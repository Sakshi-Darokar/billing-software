package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository {

    private final JdbcTemplate jdbcTemplate;


    public InvoiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SAVE INVOICE + INVOICE ITEMS INTO DATABASE
    public Invoice save(Invoice invoice) {

        // INSERT INTO INVOICE TABLE
        String invoiceSql = "INSERT INTO invoices(invoice_date, customer_id, total_amount, total_tax, discount, final_amount) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(invoiceSql,
                Timestamp.valueOf(invoice.getInvoiceDate()),
                invoice.getCustomer().getId(),
                invoice.getTotalAmount(),
                invoice.getTotalTax(),
                invoice.getDiscount(),
                invoice.getFinalAmount()
        );

        // FETCH AUTO GENERATED INVOICE ID
        Long invoiceId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        invoice.setInvoiceId(invoiceId);

        // INSERT ALL INVOICE ITEMS
        for (InvoiceItem item : invoice.getItems()) {
            String itemSql = "INSERT INTO invoice_items(invoice_id, product_id, quantity, price, tax_amount, total) VALUES (?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(itemSql,
                    invoiceId,
                    item.getProduct().getId(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getTaxAmount(),
                    item.getTotal()
            );
        }

        return invoice;
    }

    // FETCH ALL INVOICES
    public List<Invoice> findAll() {
        String sql = "SELECT * FROM invoices";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getLong("invoice_id"));
            invoice.setInvoiceDate(rs.getTimestamp("invoice_date").toLocalDateTime());
            invoice.setTotalAmount(rs.getDouble("total_amount"));
            invoice.setTotalTax(rs.getDouble("total_tax"));
            invoice.setDiscount(rs.getDouble("discount"));
            invoice.setFinalAmount(rs.getDouble("final_amount"));
            return invoice;
        });
    }

    // FETCH INVOICE BY ID
    public Optional<Invoice> findById(Long id) {
        String sql = "SELECT * FROM invoices WHERE invoice_id=?";

        List<Invoice> list = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getLong("invoice_id"));
            invoice.setInvoiceDate(rs.getTimestamp("invoice_date").toLocalDateTime());
            invoice.setTotalAmount(rs.getDouble("total_amount"));
            invoice.setTotalTax(rs.getDouble("total_tax"));
            invoice.setDiscount(rs.getDouble("discount"));
            invoice.setFinalAmount(rs.getDouble("final_amount"));
            return invoice;
        });

        return list.stream().findFirst();
    }

    // FETCH ALL INVOICES BY CUSTOMER ID
    public List<Invoice> findByCustomerId(Long customerId) {
        String sql = "SELECT * FROM invoices WHERE customer_id=?";

        return jdbcTemplate.query(sql, new Object[]{customerId}, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getLong("invoice_id"));
            invoice.setInvoiceDate(rs.getTimestamp("invoice_date").toLocalDateTime());
            invoice.setTotalAmount(rs.getDouble("total_amount"));
            invoice.setTotalTax(rs.getDouble("total_tax"));
            invoice.setDiscount(rs.getDouble("discount"));
            invoice.setFinalAmount(rs.getDouble("final_amount"));
            return invoice;
        });
    }
}
