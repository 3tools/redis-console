package cn.tools3.redis.console.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tools3.redis.console.domain.Resource;

public interface ResourceRepository extends CrudRepository<Resource,String> {

	
}
