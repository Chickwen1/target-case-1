package com.target.services;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.repos.ProductRepo;

@RunWith(SpringRunner.class)
public class ProductServiceTests {
	@InjectMocks
	ProductService productService;

	@Mock
	ProductRepo productrepositoryMock;

	/**
	 * Setup for Mockito before any test run.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

}
