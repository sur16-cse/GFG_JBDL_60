package org.geeksforgeeks.jbdl60.Service;

import org.geeksforgeeks.jbdl60.Repository.StudentRepository;
import org.geeksforgeeks.jbdl60.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository stRepository;
	
	public Student crStudent(Student student) {
		return stRepository.save(student);
	}

	public long getCount() {
		return stRepository.count();
	}
	
	public Student getStudent(int id) {
		return stRepository.getById(id);
	}
	
	
	public Student getStudentByName(String name) {
		return stRepository.findByName(name);
	}
	
}
