package com.example.EmployeeDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDemo.model.Employee;
import com.example.EmployeeDemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 repository.save(employee);
		 return "Added";
	}
	

}
