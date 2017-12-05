package cn.tools3.redis.console.utils.os.ssh2;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5
 * @description : 主要是用来执行命令的，所有的命令执行封装在这里,对于不同的命令返回的格式不同，待后续封装
 * @since : 1.0
 */
public interface Ssh2Executors {
    /**
     *
     * @param command linux命令
     * @return  执行结果输出流的字符串
     */
    String execute(String command);
}
