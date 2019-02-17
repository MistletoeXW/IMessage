package net.qiujuer.italker.factory.model.api;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RspModel<T> {
    public static final int SUCCEED = 1;

    public static final int FAILED = 0;

    public static final int ERROR_NOT_FOUND_USER = 441;
    public static final int ERROR_NOT_FOUND_GROUP = 442;
    public static final int ERROR_NOT_FOUND_GROUP_MEMBER = 443;

    public static final int ERROR_CREATE_USER = 301;
    public static final int ERROR_CREATE_GROUP = 302;
    public static final int ERROR_CREATE_MESSAGE = 303;

    public static final int ERROR_PARAMETERS = 401;
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 402;
    public static final int ERROR_PARAMETERS_EXIST_NAME = 403;

    public static final int ERROR_SERVICE = 501;

    public static final int ERROR_ACCOUNT_TOKEN = 201;
    public static final int ERROR_ACCOUNT_LOGIN = 202;
    public static final int ERROR_ACCOUNT_REGISTER = 203;

    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;

    private int code;
    private String message;
    private T data;

    public boolean success() {
        return code == SUCCEED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return data;
    }

    public void setResult(T result) {
        this.data= result;
    }
}