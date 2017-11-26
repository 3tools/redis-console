package cn.tools3.redis.console.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import cn.tools3.redis.console.domain.User;

public interface UserRepository extends DataTablesRepository<User,String> {

	User findByUsername(String username);
	
}
