package com.example.EmployeeDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeDemo.model.Employee;
import com.example.EmployeeDemo.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee){
		 employeeService.addEmployee(employee);
		 return "Created";
	}
}
