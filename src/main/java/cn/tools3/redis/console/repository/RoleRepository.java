package cn.tools3.redis.console.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tools3.redis.console.domain.Role;

public interface RoleRepository extends CrudRepository<Role,String> {

	
}
