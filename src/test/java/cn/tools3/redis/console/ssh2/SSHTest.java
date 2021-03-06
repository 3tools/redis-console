package cn.tools3.redis.console.ssh2;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.SshByPassword;
import com.jcraft.jsch.JSchException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :
 * @since : 1.0
 */
public class SSHTest {

    private final String ip = "192.168.10.110";

    private final int port = 22;

    private final String userName = "root";

    private final String password = "unioncast.cn";

    private Connection c;
    private Statement stmt;

    @Before
    public void before() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./db/data.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        try {
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void firstTest() {
        try {
            //使用目标服务器机上的用户名和密码登陆
            SSHHelper helper = new SSHHelper(ip, 22, userName, password);
            //String command = "echo hello world!";
            String command = "/usr/redis/redis-3.2.8/src/redis-cli info";
            try {
                SSHResInfo resInfo = helper.sendCmd(command);
                System.out.println("我擦，这是啥:");
                System.out.println(resInfo.getOutRes());
                //System.out.println(helper.deleteRemoteFIleOrDir(command));
                //System.out.println(helper.detectedFileExist(command));
                helper.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void secondTest() {
        Shell shell = null;
        String command = "/usr/local/redis/src/redis-cli";
        String redisCommand = "info memory";
        try {
            shell = new SshByPassword(ip, port, userName, password);
            String stdout = new Shell.Plain(shell).exec(command);
            System.err.println(stdout);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
