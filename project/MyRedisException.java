package project;

/**
 * Author : dong
 * Time:2019/8/2
 */
public class MyRedisException extends Exception{
    public MyRedisException() {
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

    public MyRedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
