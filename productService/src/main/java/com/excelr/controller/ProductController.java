package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.excelr.dto.Coupon;
import com.excelr.model.Product;
import com.excelr.repo.ProductRepo;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponService;
	
	@PostMapping("/productapi/product")
	public Product createProduct(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponService+product.getCouponCode(),Coupon.class);
		product.setCost(product.getCost()*(coupon.getDiscount()/100));
		return repo.save(product);
	}
}
