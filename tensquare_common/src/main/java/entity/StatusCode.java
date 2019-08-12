package entity;
/*
返回码实体类
 */
public class StatusCode {
    public static final int OK=20000;//成功
    public static final int ERROR=20001;//失败
    public static final int LOGINERROR=20002;//登录错误
    public static final int ACCESSERROR=20003;//权限问题
    public static final int REMOTEERROR=20004;//远程问题
    public static final int REPERROR=20005;//重复操作
}
