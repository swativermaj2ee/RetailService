package com.target.myretail.retail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.target.myretail.retail.dao.repo.PriceRepository;
import com.target.myretail.retail.dao.repo.ProductRepository;
import com.target.myretail.retail.entities.Price;
import com.target.myretail.retail.entities.Product;
import com.target.myretail.retail.exception.ResourseNotFoundException;
import com.target.myretail.retail.exception.UpdateFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceRepository priceRepository;

    public List<Product> getProducts() throws Exception {
        List<Product> productList= productRepository.getProducts();
        for(Product product:productList){
            product.setProductPrice(priceRepository.getPrice(product.getProductId()));
        }
        return productList;
    }

    public Product getProduct(int productId) throws Exception {
        Product product = productRepository.getProduct(productId);
        product.setProductPrice(priceRepository.getPrice(productId));
        return product;
    }

    public Product getProductPriceForCurrency(int productId,String currency){
        Product product = productRepository.getProduct(productId);
        product.setProductPrice(priceRepository.getPriceForCurrency(productId,currency));
        return product;
    }

    public Product updateProduct(int productId,Product product) throws Exception {
        Product product1 = getProduct(productId);
        if(null==product1){
            throw new ResourseNotFoundException("No Product record exist for Product Id ::"+productId);
        }
        List<Price> priceList = priceRepository.getPrice(productId);
        if(null==priceList){
            throw new ResourseNotFoundException("No Price record exist for Product Id ::"+productId);
        }else{
            List<Price> differences = new ArrayList<>(product.getProductPrice());
            differences.removeAll(product1.getProductPrice());
            if(differences.size()>=0){
                for(Price price : differences) {
                    if(!(priceRepository.updatePriceForCurrency(productId, price)>0)){
                        throw new UpdateFailedException("Price Updated failed for Product Id ::"+productId +" and Currency ::"+price.getCurrency());
                    }
                }
            }
        }

        return product;
    }
}
