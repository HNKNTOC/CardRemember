package com.cardRemember.model;

/**
 * Used in cases if not able to find the data in model.
 */
public class NotFoundData extends RuntimeException {
    public NotFoundData() {
    }

    public NotFoundData(String message) {
        super(message);
    }

    public NotFoundData(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundData(Throwable cause) {
        super(cause);
    }

    public NotFoundData(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
