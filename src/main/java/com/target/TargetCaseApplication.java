package com.target;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.target.models.Product;
import com.target.repos.ProductRepo;


@SpringBootApplication
public class TargetCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetCaseApplication.class, args);
	}

	/*
	 * Delete items is mongo database and then creating initial entry into mongo database
	 */
	@Bean
	public CommandLineRunner init(ProductRepo productRepo) {
		return (args) -> {
			productRepo.deleteAll();
			Product p = productRepo.save(new Product("13860428", "", 15.99));
		};
	
	}
}
