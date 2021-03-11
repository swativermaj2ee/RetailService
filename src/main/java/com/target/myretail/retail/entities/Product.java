package com.target.myretail.retail.entities;

import java.util.List;
import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private List<Price> productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Price> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<Price> productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(productName, product.productName) && Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice);
    }
}
