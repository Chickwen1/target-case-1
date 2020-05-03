package com.target.converters;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.dtos.ProductDTO;
import com.target.models.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductConverterTests {

	@Test
	public void testProductToDTOConverter() {
		Product p = new Product("1234455","Gremlins", 15.00);
		assertThat(p, instanceOf(Product.class));
		
		ProductDTO convert = ProductConverter.convert(p);
		assertEquals(convert.getProductId(), "1234455");
		assertEquals(convert.getTitle(), "Gremlins");
		assertEquals(convert.getPrice(), 15.00, 0);
		assertThat(convert, instanceOf(ProductDTO.class));
	}
	
	@Test
	public void testDTOToProductConverter() {
		ProductDTO p = new ProductDTO();
		
		p.setProductId("677890");
		p.setTitle("Deadpool");
		p.setPrice(20.50);
		assertThat(p, instanceOf(ProductDTO.class));
		
		Product convert = ProductConverter.convert(p);
		assertEquals(convert.getProductId(), "677890");
		assertEquals(convert.getTitle(), "Deadpool");
		assertEquals(convert.getPrice(), 20.50, 0);
		assertThat(convert, instanceOf(Product.class));
	}
}
