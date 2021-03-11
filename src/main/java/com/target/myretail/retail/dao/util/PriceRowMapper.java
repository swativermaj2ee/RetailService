package com.target.myretail.retail.dao.util;

import com.target.myretail.retail.entities.Currency;
import com.target.myretail.retail.entities.Price;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceRowMapper implements RowMapper<Price> {
    @Override
    public Price mapRow(ResultSet resultSet, int i) throws SQLException {
        Price price =new Price();
        price.setValue(BigDecimal.valueOf(resultSet.getDouble("price")));
        price.setCurrency(resultSet.getString("currency"));
        return price;
    }
}