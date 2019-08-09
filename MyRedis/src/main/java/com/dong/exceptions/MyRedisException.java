package com.dong.exceptions;

/**
 * Author : dong
 * Time:2019/8/9
 */
public class MyRedisException extends Exception {
    public MyRedisException() {
        super();
    }

    public MyRedisException(String message) {
        super(message);
    }

    public MyRedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRedisException(Throwable cause) {
        super(cause);
    }

    protected MyRedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
