package com.mak.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.mak.controller.CustomerController;
import com.mak.dao.InventoryDao;
import com.mak.model.Product;
import com.mak.model.Search;
import com.mak.service.ProductServiceImpl;
import com.mak.service.ProductServiceIntf;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	CustomerController productController;
	private Product products;
	private Search search;
	@Mock
	private BindingResult result;
	@Mock
	private HttpServletRequest request;
	@Mock
	InventoryDao productDao;
	ProductServiceIntf productService;
	Field field, field1, field2;
	@Mock
	private Model model;
	@Mock
	private Map<String, Object> map;
	@SuppressWarnings("rawtypes")
	@Mock
	private List list;
	private List<Product> listNew;
	

	@Before
	public void setUp() throws Exception {
		productController = new CustomerController();
		search=new Search();
		productService = new ProductServiceImpl();
		field = CustomerController.class.getDeclaredField("productService");
		field.setAccessible(true);
		field.set(productController, productService);
		field1 = ProductServiceImpl.class.getDeclaredField("productDao");
		field1.setAccessible(true);
		field1.set(productService, productDao);
		products = new Product();
		products.setId(1);
		listNew = new  ArrayList<>();
		listNew.add(products);
	}

	@Test
	public void testSaveProduct() {
		Mockito.when(productDao.findOne(Matchers.anyInt())).thenReturn(products);
		assertEquals("editsuccess", productController.saveProduct(request, products, model).getViewName());
	}
	
	@Test
	public void testSearchProductName() throws ParseException {
		
		Mockito.when(list.toString()).thenReturn("user");
		assertEquals("home", productController.products(search, model, map).getViewName());
	}
	@Test
	public void testSearchProductName_if() throws ParseException {
		assertEquals("home", productController.products(search, model, map).getViewName());
	}
	
	@Test
	public void testAddInventory() {
		listNew.clear();
		Mockito.when(productDao.findAll()).thenReturn(listNew);
		assertEquals("addInventory", productController.addInventory(products, map, model).getViewName());
	}
	@Test
	public void testAddInventory_if() {
		Mockito.when(productDao.findAll()).thenReturn(listNew);
		assertEquals("addInventory", productController.addInventory(products, map, model).getViewName());
	}

	@Test
	public void testAddInventory_Error() {
		listNew.clear();
		Mockito.when(productDao.findAll()).thenReturn(null);
		assertEquals("addInventory", productController.addInventory(products, map, model).getViewName());
	}
	
	@Test
	public void testSavePage() {
		assertEquals("addInventory", productController.SavePage(products,map,result, model).getViewName());
	}
	
	@Test
	public void testSavePage_hasErrors() {
		Mockito.when(productDao.findAll()).thenReturn(listNew);
		Mockito.when(result.hasErrors()).thenReturn(true);
		assertEquals("addInventory", productController.SavePage(products,map,result, model).getViewName());
	}

	@Test
	public void testUpdateProduct() {
		Mockito.when(request.getParameter("id")).thenReturn("1");
		Mockito.when(productDao.findOne(1)).thenReturn(products);
		assertEquals("edit", productController.updateProduct(products, request, model).getViewName());
	}

	@Test
	public void testUpdateProduct_if() {
		Mockito.when(request.getParameter("id")).thenReturn("1");
		Mockito.when(productDao.findOne(1)).thenReturn(null);
		assertEquals("edit", productController.updateProduct(products, request, model).getViewName());
	}
	
	@After
	public void tearDown() throws Exception {
		
		field = null;
		field1 = null;
		field2 = null;
		list = null;
		model = null;
		productController = null;
		productDao = null;
		products = null;
		productService = null;
		result = null;
		
	}
}
