package com.example.EmployeeDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	

}
