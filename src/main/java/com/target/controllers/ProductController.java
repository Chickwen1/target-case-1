package com.target.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.target.dtos.ProductDTO;
import com.target.models.Product;
import com.target.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/*
	 * Get Request logic that takes product id and goes to service layer method
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductInfo(@PathVariable("id") String productId) throws JsonParseException, JsonMappingException, IOException {
		Product product = null;
		product = productService.findProduct(productId);
		if(product == null) return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	/*
	 * Put Request logic that takes product object and goes to service layer method
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody ResponseEntity<Product> update (@RequestBody ProductDTO productDTO, 
			@PathVariable("id") String productId) {        
		Product temp = productService.update(productDTO);
		if(temp == null) return new ResponseEntity<>(temp, HttpStatus.NOT_FOUND);
	    return new ResponseEntity<>(temp, HttpStatus.OK);
	} 
}