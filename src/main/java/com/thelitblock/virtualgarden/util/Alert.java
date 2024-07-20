package com.thelitblock.virtualgarden.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(new Date(timestamp));
    }
}