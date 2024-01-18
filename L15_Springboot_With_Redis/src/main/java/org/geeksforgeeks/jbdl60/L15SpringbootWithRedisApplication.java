package org.geeksforgeeks.jbdl60;

import java.util.List;

import org.geeksforgeeks.jbdl60.entity.Product;
import org.geeksforgeeks.jbdl60.repo.ProductDAORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L15SpringbootWithRedisApplication {

	@Autowired
	private ProductDAORepo dao;
	public static void main(String[] args) {
		SpringApplication.run(L15SpringbootWithRedisApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Get All Product";
	}

	@GetMapping("/")
	public List<Object> fetchProducts(){
		return dao.getAll();
	}
	
	@PostMapping("/")
	public  Product save(@RequestBody Product product) {
		return dao.save(product);
	}
}
