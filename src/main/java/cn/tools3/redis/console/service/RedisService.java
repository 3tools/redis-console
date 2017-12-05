package cn.tools3.redis.console.service;

import org.springframework.stereotype.Service;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;

@Service
public class RedisService {

	/**
	 * 部署
	 */
	public void deploy(String host, int port, String user, String pass) throws Exception {
		 new Shell.Plain(new SshByPassword(host, 22, user, pass)).exec("");
	}

	public void start(String host, int port, String user, String pass, int redisPort) throws Exception {
		new Shell.Plain(new SshByPassword(host, 22, user, pass))
				.exec("screen -d -m  ~/.redis/redis-4.0.1/src/redis-server ~/.redis/" + redisPort + "/redis.conf ");
	}

	public static void main(String[] args) throws Exception {
		new RedisService().start("192.168.10.113", 22, "root", "unioncast.cn", 8989);
	}

}
