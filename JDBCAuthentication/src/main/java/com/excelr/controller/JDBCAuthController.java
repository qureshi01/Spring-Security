package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.AppUser;
import com.excelr.security.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class JDBCAuthController {

	@Autowired
	UserDetailsServiceImpl serviceImpl;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/save")
	public AppUser createUser(@RequestBody AppUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return serviceImpl.createUser(user);
	}
}
