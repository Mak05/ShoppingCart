package com.mak.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.mak.model.Product;
import com.mak.service.ProductServiceImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class ServiceTest {

	@Autowired
	ProductServiceImpl productService;
	private Product product;

	@Before
	public void setup() {
		product = new Product();
	}

	@Test
	public void testProducts() {
		product.setName("tiger");
		product.setDescription("tiger");
		product.setQuantity(10);
		product.setPrice(100.00);
		productService.addProduct(product);
		List<Product> productList = productService.listProducts();
		for (Product prod : productList) {
			assertEquals("tiger", prod.getName());
		}
	}
	@Test
	public void testProduct() {
		product = productService.getById(15);
		assertEquals("tiger", product.getName());
	}
	@Test
	public void testSearch() {
		List<Product> search = productService.searchProduct("tiger");
		for (Product prod : search)
			assertEquals("tiger", prod.getName());
	}
}