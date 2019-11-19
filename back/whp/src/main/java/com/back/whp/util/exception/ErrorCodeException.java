package com.back.whp.util.exception;

public class ErrorCodeException extends RuntimeException {
    private int code;

    public ErrorCodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCodeException(String message) {
        super(message);
    }

    public ErrorCodeException(int code) {
        super("");
        this.code = code;
    }

    public ErrorCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCodeException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }
}
