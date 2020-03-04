package com.mak.controller;

import java.security.Principal;
import java.util.List;
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

import com.mak.exception.RecordNotFoundException;
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
	 * If Admin logs in then redirect page to shop Controller 
	 * If User logs in then redirect page to Home Controller
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
	 * This controller fetch all the data from product table and put it into home.jsp Page
	 */
	@RequestMapping(value = "/home")
	public ModelAndView homePage(Map<String, Object> map, Model model) {
		logger.info("HomePage Controller");
		try {
			List<Product> productList = productService.listProducts();
			if (productList.size() == 0) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
		}
		return new ModelAndView("home");
	}

	/**
	 * @param search
	 * @param model
	 * @param map
	 * @return
	 * This controller used by user to fetch all the data from product table with search box if we search a string then 
	 * it searches the table and put the list of objects into home.jsp Page
	 */
	@RequestMapping(value = "/products")
	public ModelAndView products(@ModelAttribute("Search") Search search, Model model, Map<String, Object> map) {
		logger.info("Search Controller");
		try {
			List<Product> productList = productService.searchProduct("%" + search.getSearchItem() + "%");
			if (productList.size() == 0) {
				throw new RecordNotFoundException(search.getSearchItem());
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			model.addAttribute("message", e.getMessage());
			
		}

		return new ModelAndView("home");

	}

	/**
	 * @param inventory
	 * @param map
	 * @return
	 * This controller is used by the admin to display the form to add new product into the database
	 */
	@RequestMapping(value = "/shop")
	public ModelAndView addInventory(@ModelAttribute("inventory") Product inventory, Map<String, Object> map,
			Model model) {
		logger.info("Shop Controller");

		try {
			List<Product> productList = productService.listProducts();
			if (productList == null) {
				throw new RecordNotFoundException();
			}
			map.put("productList", productList);
		} catch (RecordNotFoundException e) {
			return new ModelAndView("addInventory").addObject("message", e.getMessage());
			
		}
		return new ModelAndView("addInventory");

	}

	/**
	 * @param product
	 * @param request
	 * @return
	 * This controller is used by the admin to display the edit form to update existing product into the database
	 */
	@RequestMapping(value = "/product")
	public ModelAndView updateProduct(@ModelAttribute("product") Product products, HttpServletRequest request,
			Model model) {
		logger.info("Update Product");
		Product product;
		try {
			String req=request.getParameter("id");
			
			int id = Integer.parseInt(req);
			product = productService.getById(id);

			if (product == null) {

				throw new RecordNotFoundException(id);
			}
		} catch (RecordNotFoundException e) {

			return new ModelAndView("edit").addObject("message", e.getMessage());
		}

		return new ModelAndView("edit", "product", product);
	}

	/**
	 * @param inventory
	 * @param map
	 * @param theBindingResult
	 * @return
	 * This controller is used by the admin to display to add new product into the database and list all the products
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView SavePage(@Valid @ModelAttribute("inventory") Product inventory, Map<String, Object> map,
			BindingResult theBindingResult, Model model) {
		logger.info("Inserting the Product Details");

		if (theBindingResult.hasErrors()) {
			map.put("productList", productService.listProducts());
			return new ModelAndView("addInventory").addObject("message", "Please fill the mandatory fields");
		} else {
			logger.info("Inserting the Product Details");
			try {
				productService.addProduct(inventory);
			} catch (Exception e) {
				model.addAttribute("message", "The record is not successfully updated. Kindly try again !");
			}

			map.put("productList", productService.listProducts());
			return new ModelAndView("addInventory").addObject("message", "Product details are successfully added");
		}

	}

	/**
	 * @param request
	 * @param product
	 * @return
	 * This controller is used to display success page if update process is success 
	 */
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public ModelAndView saveProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			Model model) {
		logger.info("Success Controller");

		try {
			productService.addProduct(product);
		} catch (Exception e) {
			model.addAttribute("message", "The record is not successfully updated. Kindly try again !");
		}
		return new ModelAndView("editsuccess");
	}

}
