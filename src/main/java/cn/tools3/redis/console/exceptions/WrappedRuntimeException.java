package cn.tools3.redis.console.exceptions;

/**
 * @author :  blentle
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5
 * @description : 系统内部包装的runtime exception ，所有自义定的异常处理器必须继承包装类
 * @since : 1.0
 */
public abstract class WrappedRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 639991545493504795L;

	public WrappedRuntimeException(String msg) {
		super(msg);
	}

	public WrappedRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	@Override
	public String getMessage() {
		return buildMessage(super.getMessage(), getCause());
	}


	/**
	 * 获取最根儿上的异常信息
	 * @return
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}


	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}


	private String buildMessage(String message, Throwable cause) {
		if (cause == null) {
			return message;
		}
		StringBuilder sb = new StringBuilder(64);
		if (message != null) {
			sb.append(message).append("; ");
		}
		sb.append("wrapped exception is ").append(cause);
		return sb.toString();
	}
}
