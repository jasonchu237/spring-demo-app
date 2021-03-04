package com.jschu.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jschu.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String displayUser(@PathVariable int userId) {
		return "User Found: " + userId;
	}
	
	@RequestMapping(value = "/{userId}/invoices", method = RequestMethod.GET)
	public String displayUserInvoices(@PathVariable int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return "invoices found for user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shoes", "Laptops", "Buttons");
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product(1, "shoes", 42.99), new Product(2, "laptops", 1200.99), new Product(3, "buttons", 3.99));
	}

}
