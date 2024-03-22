package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;


@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@PostMapping("/save")
	public Employee saveall(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	
	@GetMapping("/get")						
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
}
