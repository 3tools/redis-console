package cn.tools3.redis.console.utils.os.ssh2;

import cn.tools3.redis.console.exceptions.WrappedRuntimeException;

/**
 * @author :  blentle
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5
 * @description : 所有在执行命令时发生的异常都包装成该异常，用于统一处理
 * @since : 1.0
 */
public class CommandExecuteException extends WrappedRuntimeException {

    public CommandExecuteException(String msg) {
        super(msg);
    }


    public CommandExecuteException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
