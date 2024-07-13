package com.chandra;

import com.chandra.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext cntxt=SpringApplication.run(Application.class, args);
		ProductService productService=cntxt.getBean(ProductService.class);
		//productService.saveProduct();
		//productService.getProduct();
		//productService.Pagination();
		productService.QByExample();

	}

}
