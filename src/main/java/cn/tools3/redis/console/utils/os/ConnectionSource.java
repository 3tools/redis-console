package cn.tools3.redis.console.utils.os;

import com.jcraft.jsch.Session;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description : 代表一个连接资源(暂时只是ssh2的一个连接资源)
 * @since : 1.0
 */
public interface ConnectionSource {

    Session getSession(String host, int port , String userName, String password);

}
