package com.mak.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.controller.CustomerController;
import com.mak.dao.UsersDao;
import com.mak.model.Users;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	UsersDao usersDao;

	@Override
	public void saveUser(Users users) {
		logger.info("Save user Service");
		usersDao.save(users);
	}

	public Object findByRole(String userName) {
		logger.info("Role Service");
		return usersDao.findByRole(userName);
	}

}
