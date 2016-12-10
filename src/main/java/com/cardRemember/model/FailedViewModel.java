package com.cardRemember.model;

/**
 * Used in cases if failed display model.
 */
public class FailedViewModel extends RuntimeException {

    /**
     * Data which failed to display.
     */
    private final Data notShownData;

    public FailedViewModel(Data notShownData) {
        this.notShownData = notShownData;
    }

    public FailedViewModel(String message, Data notShownData) {
        super(message);
        this.notShownData = notShownData;
    }

    public FailedViewModel(String message, Throwable cause, Data notShownData) {
        super(message, cause);
        this.notShownData = notShownData;
    }

    public FailedViewModel(Throwable cause, Data notShownData) {
        super(cause);
        this.notShownData = notShownData;
    }

    public FailedViewModel(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Data notShownData) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.notShownData = notShownData;
    }

    public Data getNotShownData() {
        return notShownData;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+" Not shown Data = "+notShownData;
    }
}
