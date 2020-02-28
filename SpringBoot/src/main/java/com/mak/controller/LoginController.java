package com.mak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author manikandan.dhana
 *
 */
@Controller
public class LoginController {
	
	

	private static final Logger logger = LogManager.getLogger(LoginController.class);
	/**
	 * @return login
	 * This controller is used to show the login page
	 * 
	 */
	@RequestMapping("/login")
	public String showLogin() {

		logger.info("Login Controller");
		return "login";
	}

	/**
	 * @param request
	 * @param session
	 * @return login
	 *  This controller is used to show the login page from logout
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		
		
		session.invalidate();
		logger.info("Logout Controller");
		return "redirect:/login";
	}
}
