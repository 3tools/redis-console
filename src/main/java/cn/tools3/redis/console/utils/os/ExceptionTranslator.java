package cn.tools3.redis.console.utils.os;


import cn.tools3.redis.console.utils.os.ssh2.CommandExecuteException;

import java.io.IOException;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5
 * @description : 异常翻译器，将linux命令执行的错误及 Socket连接的异常转换成系统的异常的接口
 * @since : 1.0
 */
public interface ExceptionTranslator {

    /**
     *
     * @param command  执行的linux命令
     * @param ex  连接异常，
     * @return
     */
    CommandExecuteException translate(String command, IOException ex);

}
