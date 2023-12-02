package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.model.CreateEmployeeRequestModel;
import com.example.demo.model.CreateEmployeeResponseModel;

@Service
public class EmployeeService {
	HashMap<Integer, Employee>empHM=new HashMap<Integer, Employee>();
	Employee emp;
	
	public CreateEmployeeResponseModel createEmployee(@RequestBody CreateEmployeeRequestModel empRequest) {
		emp=new Employee(empRequest.getId(),empRequest.getName(),empRequest.getSal(),empRequest.getEmail(),empRequest.getSal()*2);
		empHM.put(emp.getId(),emp);
		CreateEmployeeResponseModel response=new CreateEmployeeResponseModel(empRequest.getId(),empRequest.getName(),empRequest.getSal(),empRequest.getEmail());
		return response;
	}
	
	public List<Employee>getAllEmployees(){	
		List<Employee> employees = new ArrayList<>(empHM.values());
        return employees;
	}
	
	public Employee getEmployee(int id) {
		return empHM.get(id);
	}
	
	public ResponseEntity<Employee> getEmployeeWithStatus(int id) {
		if(empHM.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(empHM.get(id));
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
