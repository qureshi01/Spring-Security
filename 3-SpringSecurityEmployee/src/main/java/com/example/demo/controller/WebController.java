package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;


@Controller
public class WebController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/uploadEmployee")
	public String uploadLaptop() {
		return "uploadEmployeeForm";
	}
	
	@PostMapping("/saveWeb")
	public String save(Employee employee) {
		repo.save(employee);
		return "success";
	}
	
	@GetMapping("/viewEmployees")
	public String viewEmployee(Model model){
		model.addAttribute("employees", repo.findAll());
		return "employees";
	}

}
