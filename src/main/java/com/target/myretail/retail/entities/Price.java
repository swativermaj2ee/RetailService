package com.target.myretail.retail.entities;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Price {

//    Map<String,String> priceMap=new HashMap<>();
//
//    public Map<String, String> getPriceMap() {
//        return priceMap;
//    }
//
//    public void setPriceMap(Map<String, String> priceMap) {
//        this.priceMap = priceMap;
//    }
    private BigDecimal value;
    private String currency;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value) && currency == price.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }
}
