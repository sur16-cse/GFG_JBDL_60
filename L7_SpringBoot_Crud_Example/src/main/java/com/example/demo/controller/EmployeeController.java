package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.model.CreateEmployeeRequestModel;
import com.example.demo.model.CreateEmployeeResponseModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public CreateEmployeeResponseModel createEmployee(@RequestBody CreateEmployeeRequestModel empRequest) {
		return employeeService.createEmployee(empRequest);
		
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping("/getStatus/{id}")
	public ResponseEntity<Employee> getEmployeeWithStatus(@PathVariable int id){
		return employeeService.getEmployeeWithStatus(id);
	}
}
