
package com.mak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mak.model.Product;

public interface InventoryDao extends CrudRepository<Product, Integer> {
	@Query(value = "SELECT * FROM product p WHERE p.name like ?1 or p.description like ?1", nativeQuery = true)
	List<Product> findBySearchItem(String searchItem);
}
