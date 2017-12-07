package cn.tools3.redis.console.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/6 0006
 * @description :
 * @since : 1.0
 */
@Getter
@Setter
@ToString
public class GenericInfo implements Serializable {

    /**
     * 占用总内存
     */
    private int usedMem;

    /**
     * 当前实例有多少key
     */
    private int totalKeys;

    /**
     * 有多少个客户端连接(包括当前系统)
     */
    private int totalClients;

    /**
     * 处理了多少个命令
     */
    private int totalCmdProcessed;

    /**
     *
     */
    private int uptime;
}
