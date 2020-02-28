package com.mak.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mak.model.Product;
import com.mak.model.Search;
import com.mak.service.ProductServiceIntf;
import com.mak.service.UserService;

/**
 * @author manikandan.dhana
 *
 */
@RestController
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	ProductServiceIntf productService;

	@Autowired
	UserService userService;

	/**
	 * @param principal
	 * @param res
	 */
	@RequestMapping("/admin")
	public void admin(Principal principal, HttpServletResponse res) {
		try {
			String loggedInUserName = principal.getName();
			Object loggedUser = (Object) userService.findByRole(loggedInUserName);
			if ((boolean) loggedUser.equals("A")) {
				res.sendRedirect("/shop");
			} else if ((boolean) loggedUser.equals("U")) {
				res.sendRedirect("/home");
			}
		} catch (Exception e) {
			logger.info(e);
		}
	}

	/**
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/home")
	public ModelAndView homePage(Map<String, Object> map) {
		map.put("productList", productService.listProducts());
		return new ModelAndView("home");
	}

	/**
	 * @param search
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/products")
	public ModelAndView products(@ModelAttribute("Search") Search search, Model model, Map<String, Object> map) {
		logger.info("Search Controller");
		map.put("productList", productService.searchProduct("%" + search.getSearchItem() + "%"));
		return new ModelAndView("home");
	}

	/**
	 * @param inventory
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/shop")
	public ModelAndView addInventory(@ModelAttribute("inventory") Product inventory, Map<String, Object> map) {
		logger.info("Shop Controller");
		map.put("productList", productService.listProducts());
		return new ModelAndView("addInventory");
	}

	/**
	 * @param product
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product")
	public ModelAndView updateProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
		logger.info("Update Product");
		int id = Integer.parseInt(request.getParameter("id"));
		product = productService.getById(id);
		return new ModelAndView("edit", "product", product);
	}

	/**
	 * @param inventory
	 * @param map
	 * @param theBindingResult
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView SavePage(@Valid @ModelAttribute("inventory") Product inventory, Map<String, Object> map,
			BindingResult theBindingResult) {
		logger.info("Inserting the Product Details");
		productService.addProduct(inventory);
		map.put("productList", productService.listProducts());
		return new ModelAndView("addInventory").addObject("message", "Product details are successfully added");

	}

	/**
	 * @param request
	 * @param product
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public ModelAndView saveProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			Map<String, Object> map) {
		logger.info("Success Controller");
		productService.addProduct(product);
		return new ModelAndView("editsuccess");
	}

}
