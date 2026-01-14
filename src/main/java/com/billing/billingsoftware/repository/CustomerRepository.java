package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;


    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Customer save(Customer customer) {

        if (customer.getId() == null) {
            // INSERT CUSTOMER
            String sql = "INSERT INTO customers(name, phone, email, address) VALUES (?, ?, ?, ?)";

            jdbcTemplate.update(sql,
                    customer.getName(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getAddress()
            );

            // FETCH AUTO GENERATED ID FROM MYSQL
            Long generatedId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
            customer.setId(generatedId);

        } else {
            // UPDATE CUSTOMER
            String sql = "UPDATE customers SET name=?, phone=?, email=?, address=? WHERE id=?";

            jdbcTemplate.update(sql,
                    customer.getName(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getAddress(),
                    customer.getId()
            );
        }

        return customer;
    }

    /*
     FETCH ALL CUSTOMERS
    */
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Customer c = new Customer();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setPhone(rs.getString("phone"));
            c.setEmail(rs.getString("email"));
            c.setAddress(rs.getString("address"));
            return c;
        });
    }

    /*
     FETCH CUSTOMER BY ID
    */
    public Optional<Customer> findById(Long id) {
        String sql = "SELECT * FROM customers WHERE id=?";

        List<Customer> list = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Customer c = new Customer();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setPhone(rs.getString("phone"));
            c.setEmail(rs.getString("email"));
            c.setAddress(rs.getString("address"));
            return c;
        });

        return list.stream().findFirst();
    }
}
