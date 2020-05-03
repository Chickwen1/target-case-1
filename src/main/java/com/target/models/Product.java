package com.target.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @document mapping to mongodb collection named 'Product'
 */
@Document(collection="Product")
public class Product {
	
	@Id
	private String productId;
	@Transient
	private String title;
	private double price;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String productId, String title, double price) {
		super();
		this.productId = productId;
		this.title = title;
		this.price = price;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getTitle() {
		return title;
	}


	public String setTitle(String title) {
		return this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
}

