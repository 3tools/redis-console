package cn.tools3.redis.console.utils.os.ssh2;

import cn.tools3.redis.console.utils.os.ConnectionSource;

import javax.sql.DataSource;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description : 命令执行的入口抽象模板，封装了打开和关闭的操作，
 * 连接的关闭和打开对客户端透明化
 * @since : 1.0
 */
public abstract class Ssh2Accessor {

    /**
     * 连接源 ，主要是获取连接会话
     */
    private ConnectionSource connectionSource;


    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }


}
