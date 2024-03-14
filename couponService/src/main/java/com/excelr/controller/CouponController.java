package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.Coupon;
import com.excelr.repo.CouponRepo;

@RestController
@CrossOrigin("*")
public class CouponController {

	@Autowired
	private CouponRepo repo;
	
	@PostMapping("/couponapi/coupon")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping("/couponapi/coupon/{code}")
	public Coupon getCoupon(@PathVariable String code) {
		return repo.findByCode(code);
	}
}
