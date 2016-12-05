package com.cardRemember.model;

/**
 * Used in cases if failed display model.
 */
public class FailedViewModel extends RuntimeException {
    public FailedViewModel() {
    }

    public FailedViewModel(String message) {
        super(message);
    }

    public FailedViewModel(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedViewModel(Throwable cause) {
        super(cause);
    }

    public FailedViewModel(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
