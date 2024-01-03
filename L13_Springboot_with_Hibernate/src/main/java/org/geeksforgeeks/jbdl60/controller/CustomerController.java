package org.geeksforgeeks.jbdl60.controller;

import org.geeksforgeeks.jbdl60.model.CreateCustomerRequestModel;
import org.geeksforgeeks.jbdl60.model.CreateCustomerResponseModel;
import org.geeksforgeeks.jbdl60.model.GetCustomerResponseModel;
import org.geeksforgeeks.jbdl60.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@RequestMapping("/test")
	public String testApi() {
		return "Test Api works";

	}

	@PostMapping("/create")
	public  CreateCustomerResponseModel createCustomer(@RequestBody CreateCustomerRequestModel requestModel) {
		return customerService.createCustomer(requestModel);
	}
	
	@GetMapping("/get/{id}")
	public GetCustomerResponseModel getEmployeeByID(@PathVariable int id) {
		return customerService.getEmployeeByID(id);
	}
	
	//add all customers
}
