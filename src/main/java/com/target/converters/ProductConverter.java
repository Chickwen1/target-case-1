package com.target.converters;

import com.target.dtos.ProductDTO;
import com.target.models.Product;

public class ProductConverter {

private ProductConverter() {
		
	}
	
	public static ProductDTO convert(Product p) {
		ProductDTO product = new ProductDTO();
		product.setProductId(p.getProductId());
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		return product;
	}
	
	public static Product convert(ProductDTO p) {
		Product product = new Product();
		product.setProductId(p.getProductId());
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		return product;
	}
}
