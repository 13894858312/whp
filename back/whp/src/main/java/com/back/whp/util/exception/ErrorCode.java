package com.back.whp.util.exception;

public class ErrorCode {
    /**
     * 出错
     */
    public static final int ERROR = -1;
    /**
     * 正常
     */
    public static final int OK = 0;
    /**
     * 参数错误
     */
    public static final int BAD_REQUEST = 400;

    public static final int FORBIDDEN = 403;

    public static final int USERNAME_NOT_EXISTS = 10;// 用户名不存在

    public static final int PASSWORD_WRONG = 11; // 密码错误

    public static final int TOKEN_NOT_EXISTS = 12; // token不存在

    public static final int ALARM_NOT_EXISTS = 20;

    public static final int CHEMICAL_NOT_EXISTS = 30;

    public static final int CHEMICAL_ALREADY_HAS_CODE = 31;
}
