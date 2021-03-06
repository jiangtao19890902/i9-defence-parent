package i9.defence.platform.utils;

/**
 * 创建时间：2017年12月14日 下午2:51:57
 * 
 * @author lby
 * @version
 * 
 */
public class ErrorCode {

    /**
     * 未申请下载
     */
    public static final int NOT_APPLY = 10001;

    /**
     * 未同意申请下载
     */
    public static final int NOT_ACCESS = 10002;

    /**
     * 增删改查异常
     */
    public static final int CRUD_ERROR = 10003;

    /**
     * 用户未登录
     */
    public static final int USER_LOGIN_ERROR = 9999;

    /**
     * 阿里云短信验证错误代码
     */
    public static final int ALIYUN_NOT_ENOUGH_ERROR = 10017;

    /**
     * 阿里云短信手机号错误
     */
    public static final int ALIYUN_ERROR_PHONE = 10019;

}
