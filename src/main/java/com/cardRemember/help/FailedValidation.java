package com.cardRemember.help;

/**
 * Used in cases if model not validation.
 */
public class FailedValidation extends RuntimeException {
    public FailedValidation() {
        super();
    }

    public FailedValidation(String message) {
        super(message);
    }

    public FailedValidation(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedValidation(Throwable cause) {
        super(cause);
    }

    protected FailedValidation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
