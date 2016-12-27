package com.cardRemember.model;

/**
 * Used in cases if not able to find the data in model.
 */
public class FailedGettingData extends RuntimeException {
    public FailedGettingData() {
    }

    public FailedGettingData(String message) {
        super(message);
    }

    public FailedGettingData(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedGettingData(Throwable cause) {
        super(cause);
    }

    public FailedGettingData(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
