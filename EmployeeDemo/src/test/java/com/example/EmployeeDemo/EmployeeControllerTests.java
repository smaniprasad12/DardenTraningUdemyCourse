package com.example.EmployeeDemo;

import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.hamcrest.CoreMatchers;

import com.example.EmployeeDemo.model.Employee;
import com.example.EmployeeDemo.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;
	@Autowired
	private ObjectMapper objectMapper;
	
	public void CreateEmployee() throws Exception {
		Employee employee = Employee.builder()
				.id(1)
				.firstName("Sai")
				.lastName("Mukesh")
				.role("Analyst")
				.build();
				
		BDDMockito.given(employeeService.addEmployee(ArgumentMatchers.any(Employee.class)))
		.willAnswer((invocation)->invocation.getArgument(0));
		
		ResultActions response = mockMvc.perform(post("/api/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee)));
		
		response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(employee.getId())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.role", CoreMatchers.is(employee.getRole())));
		
			
		
		
	}
	
	

}
