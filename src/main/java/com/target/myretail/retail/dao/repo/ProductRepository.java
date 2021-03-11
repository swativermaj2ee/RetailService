package com.target.myretail.retail.dao.repo;

import com.target.myretail.retail.dao.util.ProductRowMapper;
import com.target.myretail.retail.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getProducts() throws Exception {
        return jdbcTemplate.query("select * from PRODUCT",new ProductRowMapper());
    }

    public Product getProduct(int productId) {
        return jdbcTemplate.queryForObject("select * from PRODUCT where id=" + productId,
                new ProductRowMapper());
    }

}
