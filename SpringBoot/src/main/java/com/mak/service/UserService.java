package com.mak.service;

import com.mak.model.Users;

public interface UserService {

	public void saveUser(Users users);

	public Object findByRole(String loggedInUserName);
}
