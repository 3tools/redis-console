package cn.tools3.redis.console.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tools3.redis.console.domain.Menu;

public interface MenuRepository extends CrudRepository<Menu,String> {

	
}
