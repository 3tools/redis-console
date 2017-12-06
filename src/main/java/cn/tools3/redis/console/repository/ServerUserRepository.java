package cn.tools3.redis.console.repository;

import cn.tools3.redis.console.domain.ServerUser;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface ServerUserRepository extends DataTablesRepository<ServerUser,String> {

	
}
