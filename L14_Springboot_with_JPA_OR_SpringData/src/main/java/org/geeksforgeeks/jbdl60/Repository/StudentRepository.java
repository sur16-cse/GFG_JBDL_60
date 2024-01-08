package org.geeksforgeeks.jbdl60.Repository;

import java.util.List;

import org.geeksforgeeks.jbdl60.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    public Student findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.name = ?1 AND s.id = ?2")
    public List<Student> findByNameAndId(String name, int id);
}
