package com.dong.exceptions;

/**
 * Author : dong
 * Time:2019/8/9
 */
public class RemoteException extends Exception {
    public RemoteException() {
        super();
    }

    public RemoteException(String message) {
        super(message);
    }

    public RemoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoteException(Throwable cause) {
        super(cause);
    }

    protected RemoteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
