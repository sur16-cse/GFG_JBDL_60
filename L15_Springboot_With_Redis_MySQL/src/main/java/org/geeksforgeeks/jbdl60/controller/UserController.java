package org.geeksforgeeks.jbdl60.controller;

import java.util.Optional;

import org.geeksforgeeks.jbdl60.entity.User;
import org.geeksforgeeks.jbdl60.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private final UserRepo userRepo;
	
	@Autowired
	public UserController(UserRepo user) {
		this.userRepo=user;
	}
	
	@RequestMapping("/load")
	public String load() {
		System.out.println("Load Called"+userRepo.count());
		User surbhi=new User(1,"surbhi","10");
		User john=new User(2,"john","100");
		User priya=new User(3,"priya","1000");
		
		userRepo.save(surbhi);
		userRepo.save(john);
		userRepo.save(priya);
		return "repo count"+userRepo.count();
	}
	
	@RequestMapping("/get/{userId}")
	@Cacheable(value = "jbdl-60-users",key = "#userId")
	public Optional<User> getUser(@PathVariable int userId){
		return userRepo.findById(userId);
	}
	
	@RequestMapping("/delete/{userId}")
	@CacheEvict(value = "jbdl-60-users",key = "#userId")
	public String deleteUser(@PathVariable int userId){
		userRepo.deleteById(Integer.valueOf(userId));
		return "Success deleted";
	}
	
}
