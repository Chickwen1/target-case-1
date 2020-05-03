package com.target.dtos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductDTOTests {

	@Test
	public void testProductDTOObjectWithArgs() {
		ProductDTO p = new ProductDTO("1234455","Gremlins", 15.00);
		
		assertEquals(p.getProductId(), "1234455");
		assertEquals(p.getTitle(), "Gremlins");
		assertEquals(p.getPrice(), 15.00, 0);
	}
	
	@Test
	public void testProductDTOObjectWithNoArgs() {
		ProductDTO p = new ProductDTO();
		
		p.setProductId("677890");
		p.setTitle("Deadpool");
		p.setPrice(20.50);
		
		assertEquals(p.getProductId(), "677890");
		assertEquals(p.getTitle(), "Deadpool");
		assertEquals(p.getPrice(), 20.50, 0);
	}
}
