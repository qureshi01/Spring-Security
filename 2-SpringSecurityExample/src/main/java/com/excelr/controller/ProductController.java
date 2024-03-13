package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.Product;
import com.excelr.repo.ProductRepo;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductRepo repo;
	
	@PostMapping("/save")						//ADMIN
	public Product create(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping("/get")						//ADMIN & USER
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
}
