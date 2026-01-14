package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // INSERT OR UPDATE PRODUCT
    public Product save(Product product) {

        if (product.getId() == null) {

            String sql = "INSERT INTO products(name, price, gst_percentage, stock_quantity) VALUES (?, ?, ?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, product.getName());
                ps.setDouble(2, product.getPrice());
                ps.setDouble(3, product.getGstPercentage());
                ps.setInt(4, product.getStockQuantity());
                return ps;
            }, keyHolder);

            product.setId(keyHolder.getKey().longValue());

        } else {

            String sql = "UPDATE products SET name=?, price=?, gst_percentage=?, stock_quantity=? WHERE id=?";

            jdbcTemplate.update(sql,
                    product.getName(),
                    product.getPrice(),
                    product.getGstPercentage(),
                    product.getStockQuantity(),
                    product.getId()
            );
        }

        return product;
    }

    // FETCH ALL PRODUCTS
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setGstPercentage(rs.getDouble("gst_percentage"));
            p.setStockQuantity(rs.getInt("stock_quantity"));
            return p;
        });
    }

    // FETCH PRODUCT BY ID
    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM products WHERE id=?";

        List<Product> list = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setGstPercentage(rs.getDouble("gst_percentage"));
            p.setStockQuantity(rs.getInt("stock_quantity"));
            return p;
        });

        return list.stream().findFirst();
    }

    // DELETE PRODUCT
    public void deleteById(Long id) {
        String sql = "DELETE FROM products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
