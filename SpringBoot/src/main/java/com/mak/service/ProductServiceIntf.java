package com.mak.service;

import java.util.List;

import com.mak.model.Product;

public interface ProductServiceIntf {

	public void addProduct(Product b);

	public List<Product> listProducts();

	public List<Product> searchProduct(String searchItem);

	public Product getById(int id);

}
