package com.back.whp.dto;

import java.beans.Transient;
import java.util.function.Supplier;

public class SimpleResponse<T> {
    private final T data;
    private final String exception;
    private int code;

    private SimpleResponse() {
        this.code = 0;
        this.data = null;
        this.exception = null;
    }

    private SimpleResponse(boolean success) {
        this.code = success ? 0 : -1;
        this.data = null;
        this.exception = null;
    }

    public SimpleResponse(int code, T data) {
        this(code, data, (String) null);
    }

    public SimpleResponse(int code, T data, String exception) {
        this.code = code;
        this.data = data;
        this.exception = exception;
    }

    public SimpleResponse(int code) {
        this.code = code;
        this.data = null;
        this.exception = null;
    }

    public static <T> SimpleResponse<T> checkNull(T data) {
        return data == null ? new SimpleResponse(-3, (Object) null) : ok(data);
    }

    public static <T> SimpleResponse<T> ifTrue(boolean result, Supplier<T> data) {
        return result ? ok(data.get()) : new SimpleResponse(false);
    }

    public static SimpleResponse<String> exception(Exception exception) {
        return new SimpleResponse(2500, exception.getMessage());
    }

    public static SimpleResponse<String> errorCode(int errorCode, String message) {
        return new SimpleResponse(errorCode, message, (String) null);
    }

    public static <T> SimpleResponse<T> error(T data) {
        return new SimpleResponse(-1, data);
    }

    public static <T> SimpleResponse<T> ok(T data) {
        return new SimpleResponse(0, data);
    }

    public static <T> SimpleResponse<T> checkBoolean(boolean result) {
        return new SimpleResponse(result);
    }

    public T getData() {
        return this.data;
    }

    public int getCode() {
        return this.code;
    }

    @Transient
    public String getException() {
        return this.exception;
    }

    public String toString() {
        return "SimpleResponse{code=" + this.code + ", data=" + this.data + ", exception='" + this.exception + '\'' + '}';
    }
}
