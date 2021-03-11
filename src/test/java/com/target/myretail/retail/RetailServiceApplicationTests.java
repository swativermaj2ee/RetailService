package com.target.myretail.retail;

import com.target.myretail.retail.controller.RetailServiceController;
import com.target.myretail.retail.dao.repo.ProductRepository;
import com.target.myretail.retail.entities.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = RetailServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RetailServiceApplicationTests {
    @InjectMocks
    private RetailServiceController retailServiceController;

    @Mock
    private ProductRepository productRepository;


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
    public void testAllProducts() {
		LinkedHashMap<String,String> productList = (LinkedHashMap<String,String>) restTemplate
                .getForObject("http://localhost:8080"  + "/products", Object.class);
        assertTrue(
                productList.size() == 5);
    }


}
