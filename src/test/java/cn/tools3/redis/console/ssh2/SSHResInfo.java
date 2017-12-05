package cn.tools3.redis.console.ssh2;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :
 * @since : 1.0
 */
public class SSHResInfo {
    private int exitStuts;//返回状态码 （在linux中可以通过 echo $? 可知每步执行令执行的状态码）
    private String outRes;//标准正确输出流内容
    private String errRes;//标准错误输出流内容


    public SSHResInfo(int exitStuts, String outRes, String errRes) {
        super();
        this.exitStuts = exitStuts;
        this.outRes = outRes;
        this.errRes = errRes;
    }

    public SSHResInfo() {
        super();
    }

    public int getExitStuts() {
        return exitStuts;
    }

    public void setExitStuts(int exitStuts) {
        this.exitStuts = exitStuts;
    }

    public String getOutRes() {
        return outRes;
    }

    public void setOutRes(String outRes) {
        this.outRes = outRes;
    }

    public String getErrRes() {
        return errRes;
    }

    public void setErrRes(String errRes) {
        this.errRes = errRes;
    }

    @Override
    public String toString() {
        return "SSHResInfo [exitStuts=" + exitStuts + ", outRes=" + outRes + ", errRes=" + errRes + "]";
    }
}
