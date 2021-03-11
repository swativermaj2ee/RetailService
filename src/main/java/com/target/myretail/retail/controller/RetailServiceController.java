package com.target.myretail.retail.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.target.myretail.retail.entities.Product;
import com.target.myretail.retail.exception.ResourseNotFoundException;
import com.target.myretail.retail.exception.UpdateFailedException;
import com.target.myretail.retail.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RetailServiceController {
    @Autowired
    RetailService retailService;

    @GetMapping("/products")
    public List<Product> getProduct() throws Exception {
        return retailService.getProducts();

    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable(name = "productId") int productId) throws Exception {
        return retailService.getProduct(productId);

    }

    @GetMapping("/products/{productId}/price")
    public Product getProductPriceForCurrency(@PathVariable(name = "productId") int productId,@RequestParam(name="currency") String currency) throws Exception {
        return retailService.getProductPriceForCurrency(productId,currency);

    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(name = "productId") int productId, @RequestBody Product product) throws Exception {
        return retailService.updateProduct(productId, product);

    }

}
