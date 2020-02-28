package com.mak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mak.model.Users;
import com.mak.service.UserService;

@RestController
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@RequestMapping("/showRegistration")
	public ModelAndView showRegisterForm() {
		return new ModelAndView("registration-page", "users", new Users());
	}

	@PostMapping("saveRegistrationForm")
	public ModelAndView saveRegistrationForm(@ModelAttribute("users") Users users) {
		users.setEnabled(1);
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		userService.saveUser(users);

		return new ModelAndView("redirect:/login");

	}
}
