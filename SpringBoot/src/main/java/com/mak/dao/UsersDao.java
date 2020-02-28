package com.mak.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mak.model.Users;

public interface UsersDao extends CrudRepository<Users, Integer> {
	@Query(value = "Select roles from roles where users=?1", nativeQuery = true)
	Object findByRole(String userName);
}
