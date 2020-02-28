package com.mak.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.controller.CustomerController;
import com.mak.dao.InventoryDao;
import com.mak.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceIntf {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	InventoryDao productDao;

	public void addProduct(Product product) {
		logger.info("Add Product Service");
		productDao.save(product);
	}

	public List<Product> listProducts() {
		logger.info("List Product Service");
		List<Product> productList = (List<Product>) productDao.findAll();
		return productList;
	}

	public List<Product> searchProduct(String searchItem) {
		logger.info("Search Product Service");
		List<Product> productList = (List<Product>) productDao.findBySearchItem(searchItem);
		return productList;
	}

	@Override
	public Product getById(int id) {
		logger.info("Get Product Service");
		return productDao.findOne(id);
	}

}
