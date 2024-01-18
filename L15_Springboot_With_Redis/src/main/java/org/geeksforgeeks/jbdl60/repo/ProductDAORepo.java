package org.geeksforgeeks.jbdl60.repo;

import java.util.List;

import org.geeksforgeeks.jbdl60.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAORepo {
	private static final String HASH_KEY="JBDL60_Product";
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public Product save(Product product) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}
	
	public List<Object>getAll(){
		return template.opsForHash().values(HASH_KEY);
	}
}
