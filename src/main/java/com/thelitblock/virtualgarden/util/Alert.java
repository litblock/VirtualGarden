package com.thelitblock.virtualgarden.util;

public class Alert {
    private final String message;
    private final long timestamp;

    public Alert(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}