package com.target.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.converters.ProductConverter;
import com.target.dtos.ProductDTO;
import com.target.exceptions.InvalidProductException;
import com.target.models.Product;
import com.target.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	/*
	 * Get a product id from mongodb, then use external site to retrieve product title. Product is then returned
	 */
	public Product findProduct(String productId) throws JsonParseException, JsonMappingException, IOException {
		Product product = validateProductId(productId);
		return product;
	}
	
	/*
	 * Look if request is valid then update transaction
	 */

	public Product update(ProductDTO productDTO) {
		Product product = ProductConverter.convert(productDTO);
		validateProductId(product.getProductId());
		return productRepo.save(product);
	}
	
	private Product validateProductId (String productId) {
		Product product = productRepo.findCustomByProductId(productId);
		if (product == null) {
			throw new InvalidProductException("Invalid");
		}
		product.setTitle(this.getExternalTitle(productId));
		return product;
		
	}
	
	/*
	 * Method to call external site, then get JSON object. If valid, it will grab product title from map
	 */
	
	@SuppressWarnings("unchecked")
	private String getExternalTitle(String id) {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		String URL = "https://redsky.target.com/v2/pdp/tcin/" + id
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("rawtypes")
		Map<String, Map> map;
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		HttpStatus responseCode = response.getStatusCode();
		try {
			map = mapper.readValue(response.getBody(), Map.class); 
			Map<String, Map> productMap = map.get("product");
			Map<String, Map> itemMap = productMap.get("item");
			Map<String, String> productDescriptionMap = itemMap.get("product_description");

			if (responseCode == HttpStatus.OK) {
				return product.setTitle(productDescriptionMap.get("title"));
			}
		} catch (Exception e) {
			System.out.println(responseCode);
		}

		return null;

}
}
