package com.target.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.target.models.Product;

public interface ProductRepo extends MongoRepository<Product, String>{

	@Query(("{productId:'?0'}"))
	public Product findCustomByProductId(String productId);
}