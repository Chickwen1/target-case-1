package com.target.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.target.converters.ProductConverter;
import com.target.dtos.ProductDTO;
import com.target.exceptions.InvalidProductException;
import com.target.models.Product;
import com.target.repos.ProductRepo;

@RunWith(SpringRunner.class)
public class ProductServiceTests {
	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepo productrepoMock;

	/**
	 * Setup for Mockito before any test run.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getProductByIdTest() throws Exception {
		Product p = new Product("13860428", "", 11.00);
		when(productrepoMock.findCustomByProductId(Mockito.anyString())).thenReturn(p);
		
		productrepoMock.findCustomByProductId(p.getProductId());
		Product actualProduct = productService.findProduct("13860428");
		Product result = new Product("13860428", "The Big Lebowski (Blu-ray)", 11.00);
		
		assertEquals(result.getProductId(), actualProduct.getProductId());
	}
	
	@Test(expected=InvalidProductException.class)
	public void getProductByWrongIdTest() throws Exception {
		Product p = new Product();
		when(productrepoMock.findCustomByProductId(Mockito.anyString())).thenThrow(InvalidProductException.class);
		
		productService.findProduct(p.getProductId());
	}
}
