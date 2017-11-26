package cn.tools3.redis.console.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import cn.tools3.redis.console.domain.Server;

public interface ServerRepository extends DataTablesRepository<Server,String> {

	
}
