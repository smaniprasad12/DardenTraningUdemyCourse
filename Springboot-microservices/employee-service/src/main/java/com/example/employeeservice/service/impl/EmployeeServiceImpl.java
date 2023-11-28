package com.example.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import com.example.employeeservice.Dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee(
			employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail()
			);	
		Employee savedEmployee = employeeRepository.save(employee);
		
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail()
				);
		
		return savedEmployeeDto;
	}

}
