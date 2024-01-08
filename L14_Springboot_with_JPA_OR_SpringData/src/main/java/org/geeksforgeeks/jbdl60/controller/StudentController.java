package org.geeksforgeeks.jbdl60.controller;

import org.geeksforgeeks.jbdl60.Service.StudentService;
import org.geeksforgeeks.jbdl60.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/test")
	public String test() {
		return "Test Api Works";
	}
	
	@PostMapping("/create")
	public Student crStudent(@RequestBody Student student) {
		return studentService.crStudent(student);
	}

	@GetMapping("/count")
	public long getCount() {
		return studentService.getCount();
	}
	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	
	@GetMapping("/getbyname/{name}")
	public Student getStudentByName(@PathVariable String name){
		return studentService.getStudentByName(name);
	}
}
