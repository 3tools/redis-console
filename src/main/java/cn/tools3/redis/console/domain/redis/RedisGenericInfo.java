package cn.tools3.redis.console.domain.redis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/6 0006
 * @description : redis实例的公共信息,如想一次获取所有信息 一个info 命令就搞定了
 * @since : 1.0
 */
@Getter
@Setter
@ToString
public class RedisGenericInfo {
    /**
     * redis服务器
     */
    private String host;

    /**
     * 服务器名称
     */
    private String name;

    /**
     * 服务器ip
     */
    private String ip;

    /**
     * 占用端口(可能出现伪多实例的情况，如一台物理机开启多个端口redis)
     */
    private int port;
}
