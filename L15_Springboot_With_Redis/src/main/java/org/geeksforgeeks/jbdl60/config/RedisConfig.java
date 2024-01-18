package org.geeksforgeeks.jbdl60.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
	@Bean
	public JedisConnectionFactory connectionFactory() {
		 RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost",6379);
		 return new JedisConnectionFactory(configuration);
	}
	
	@Bean
	public RedisTemplate<String, Object>template(){
		RedisTemplate<String, Object>template =new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
}
