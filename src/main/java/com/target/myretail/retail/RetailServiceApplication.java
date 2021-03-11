package com.target.myretail.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailServiceApplication.class, args);
	}

}
