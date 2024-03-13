package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.excelr.model.Product;
import com.excelr.repo.ProductRepo;

@Controller
public class WebController {
	
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/uploadLaptop")
	public String uploadLaptop() {
		return "uploadLaptopForm";
	}
	
	@PostMapping("/saveWeb")
	public String save(Product product) {
		repo.save(product);
		return "success";
	}
	
	@GetMapping("/viewLaptops")
	public String viewLaptops(Model model){
		model.addAttribute("products", repo.findAll());
		return "products";
	}
}
