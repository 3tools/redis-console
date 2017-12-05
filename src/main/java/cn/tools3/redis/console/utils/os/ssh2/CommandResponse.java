package cn.tools3.redis.console.utils.os.ssh2;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/05
 * @description :  linux 命令执行的结果
 * @since : 1.0
 */
public final class CommandResponse  {

    /**
     * 命令执行返回的状态码
     */
    private int statusCode;

    /**
     * 返回正确的结果输出流
     */
    private String response;

    /**
     * 返回错误的结果输出流
     */
    private String errorMsg;


    public CommandResponse() {

    }

    public CommandResponse(int statusCode, String response, String errorMsg) {
        this.statusCode = statusCode;
        this.response = response;
        this.errorMsg = errorMsg;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SSH2 request by command  [response code=");
        sb.append(statusCode);
        sb.append("  content=");
        sb.append(response);
        sb.append("  errorMsg=");
        sb.append(errorMsg);
        sb.append(" ]");
        return sb.toString();
    }

}
