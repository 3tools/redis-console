package cn.tools3.redis.console.service;

import org.springframework.stereotype.Service;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;

@Service
public class RedisService {

	private String redisFileName = "redis-4.0.1.tar";

	private String appUrl = "http://localhost:10000";

	/**
	 * 部署
	 */
	public void deploy(String host, int port, String user, String pass) throws Exception {
		Shell.Plain plain = new Shell.Plain(new SshByPassword(host, 22, user, pass));
		plain.exec("mkdir ~/.redis");
		String check = plain.exec("cd ~/.redis && ls -lrt");
		if (!check.contains(redisFileName)) {
			plain.exec("cd ~/.redis && wget " + appUrl + "/" + redisFileName);
			plain.exec("cd ~/.redis && tar -xvf " + redisFileName);
			String redisDir = redisFileName.substring(0, redisFileName.lastIndexOf("."));
			plain.exec("cd ~/.redis/" + redisDir + " && make");
		}
	}

	/**
	 * 启动redis
	 * 
	 * @param host
	 * @param port
	 * @param user
	 * @param pass
	 * @param redisPort
	 * @throws Exception
	 */
	public void start(String host, int port, String user, String pass, int redisPort) throws Exception {
		new Shell.Plain(new SshByPassword(host, 22, user, pass))
				.exec("screen -d -m  ~/.redis/redis-4.0.1/src/redis-server ~/.redis/" + redisPort + "/redis.conf ");
	}

	public static void main(String[] args) throws Exception {
		new RedisService().start("192.168.10.113", 22, "root", "unioncast.cn", 8989);
	}

}
