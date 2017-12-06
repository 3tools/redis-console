package cn.tools3.redis.console.domain.redis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/6
 * @description : redis server实例相关信息
 * [unioncloud@sp-04 src]$ /usr/local/redis/src/redis-cli
 * 127.0.0.1:6379> info server
 * # Server
 * redis_version:3.2.8
 * redis_git_sha1:00000000
 * redis_git_dirty:0
 * redis_build_id:94f81df9a93ddda4
 * redis_mode:standalone
 * os:Linux 3.10.0-514.10.2.el7.x86_64 x86_64
 * arch_bits:64
 * multiplexing_api:epoll
 * gcc_version:4.8.5
 * process_id:1846
 * run_id:3f0675144f8a6ec475d53e828647ee045b07fbfc
 * tcp_port:6379
 * uptime_in_seconds:165088
 * uptime_in_days:1
 * hz:10
 * lru_clock:2577091
 * executable:/usr/local/redis/src/redis-server
 * config_file:/usr/local/redis/redis.conf
 * 127.0.0.1:6379>
 * <p>
 * todo:待server信息维护好以后直接将下面的generi对象里的部分属性换成server对象
 * @since : 1.0
 */
@Getter
@Setter
@ToString
public class RedisServerInfo {
    /**
     * 基本信息
     */
    private RedisGenericInfo genericInfo;

    /**
     * redis版本信息
     */
    private String redisVersion;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private String redisGitSha1;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private int redisGitDirty;

    /**
     * 启动生成的id
     */
    private String redisBuildId;

    /**
     * 当前实例启动的模式:独立启动、cluster模式启动
     * standalone
     * cluster
     */
    private String redisMode;

    /**
     * redis所在的宿主机操作系统版本
     */
    private String os;

    /**
     * 宿主机操作系统是64位还是32位
     */
    private int archBits;

    /**
     * 通信io多路复用使用的api,不配置默认使用epoll
     */
    private String multiplexingApi = "epoll";

    /**
     * 编译redis源码使用的gcc的版本
     */
    private String gccVersion;

    /**
     * 占用进程id
     */
    private String processId;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private String runId;

    /**
     * 对外tcp端口
     */
    private int tcpPort;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private int uptimeInSeconds;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private int uptimeInDays;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private int hz;

    /**
     * 啥意思，不知道
     * todo:待注释
     */
    private int lruClock;

    /**
     * 启动server入口所在的目录
     */
    private String executable;

    /**
     * 启动时使用的配置文件
     */
    private String configFile;


}
