package com.target.myretail.retail.dao.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myretail.retail.dao.util.PriceRowMapper;
import com.target.myretail.retail.entities.Price;
import com.target.myretail.retail.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PriceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Map<Integer, String> priceMap = new HashMap<Integer, String>();
    ObjectMapper objectMapper = new ObjectMapper();

    PriceRepository() {
        priceMap.put(13860428, "{\"value\": 13.45,\"currency\": \"USD\"}");
        priceMap.put(54456119, "{\"value\": 13.45,\"currency\": \"USD\"}");
        priceMap.put(13264003, "{\"value\": 13.45,\"currency\": \"USD\"}");
        priceMap.put(12954218, "{\"value\": 13.45,\"currency\": \"USD\"}");
        priceMap.put(12954218, "{\"value\": 13.45,\"currency\": \"USD\"}");
    }


    public List<Price> getPrice(int productId) {
        return jdbcTemplate.query("select * from PRICE where id=" + productId,
                new PriceRowMapper() {
                });
    }

    public List<Price> getPriceForCurrency(int productId,String currency){
        return jdbcTemplate.query("select * from PRICE where id=" + productId +" and currency= '"+currency+"'",
                new PriceRowMapper() {
                });
    }

    public int updatePriceForCurrency(int productId,Price price) {
        return jdbcTemplate.update("update PRICE set  price=" + price.getValue() + " where id=" + productId +" and currency='"+price.getCurrency()+"'");
    }

}
