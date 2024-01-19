package org.geeksforgeeks.jbdl60.repo;

import org.geeksforgeeks.jbdl60.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{
	
}
