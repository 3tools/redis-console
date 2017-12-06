package cn.tools3.redis.console.domain;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/6 0006
 * @description : 单台Redis占用内存的情况, 使用memory info命令获取:
 * [unioncloud@sp-04 src]$ /usr/local/redis/src/redis-cli
 * 192.168.10114:6379> info memory
 * # Memory
 * used_memory:1910968
 * used_memory_human:1.82M
 * used_memory_rss:9924608
 * used_memory_rss_human:9.46M
 * used_memory_peak:1972736
 * used_memory_peak_human:1.88M
 * total_system_memory:16554336256
 * total_system_memory_human:15.42G
 * used_memory_lua:37888
 * used_memory_lua_human:37.00K
 * maxmemory:0
 * maxmemory_human:0B
 * maxmemory_policy:noeviction
 * mem_fragmentation_ratio:5.19
 * mem_allocator:jemalloc-4.0.3
 * 192.168.10114:6379>
 *
 * todo:待server信息维护好以后直接将下面的部分属性换成server对象
 * @since : 1.0
 */
public class RedisMemInfo {

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

    /**
     * redis使用的内存总量
     * 单位：字节
     */
    private int usedMem;

    /**
     * 从操作系统上显示已经分配的内存总量
     * 单位：同上
     */
    private int usedMemRss;

    /**
     * Redis曾经使用内存的峰值
     */
    private int useMemPeak;

    /**
     * 服务器的物理总内存
     */
    private int totalSysMem;

    /**
     * redis中使用lua脚本所占用的内存量
     */
    private int useMemLua;

    /**
     * 允许redis占用的最大内存， 0 表示不限制，取决于服务器的物理内存
     */
    private int maxMem;

    /**
     * 内存达到最大限制的驱逐策略,
     * 不配置默认没有驱逐策略
     */
    private String maxMemEvictPolicy = "noeviction";

    /**
     *  内存碎片比率
     */
    private int memFragRatio;

    /**
     * 使用的内存分配器，安装时指定的
     */
    private String memAllocator;

}
