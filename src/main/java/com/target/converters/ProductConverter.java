package com.target.converters;

import com.target.dtos.ProductDTO;
import com.target.models.Product;

public class ProductConverter {

private ProductConverter() {
		
	}
	
/*
 * Convert Data Transfer Object response to Product Object
 */
	public static ProductDTO convert(Product p) {
		ProductDTO product = new ProductDTO();
		product.setProductId(p.getProductId());
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		return product;
	}
	

/*
 * Convert Product Object to Data Transfer Object response 
 */
	public static Product convert(ProductDTO p) {
		Product product = new Product();
		product.setProductId(p.getProductId());
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		return product;
	}
}
