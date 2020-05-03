package com.target;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.target.models.Product;
import com.target.repos.ProductRepo;


@SpringBootApplication
public class TargetCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetCaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ProductRepo productRepo) {
		return (args) -> {
			productRepo.deleteAll();
			Product p = productRepo.save(new Product("13860428", "", 15.99));
		};
	
	}
}
