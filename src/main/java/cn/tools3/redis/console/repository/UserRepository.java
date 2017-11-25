package cn.tools3.redis.console.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tools3.redis.console.domain.User;

public interface UserRepository extends CrudRepository<User,String> {

	User findByUsername(String username);
	
}
