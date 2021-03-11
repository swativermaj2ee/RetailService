package com.target.myretail.retail.dao.util;

import com.target.myretail.retail.entities.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product =new Product();
        product.setProductId(resultSet.getInt("id"));
        product.setProductName(resultSet.getString("name"));
        return product;
    }
}
