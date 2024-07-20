package com.thelitblock.virtualgarden.util;

import java.util.ArrayList;
import java.util.List;

public class AlertManager {
    private final List<Alert> alerts = new ArrayList<>();

    public void addAlert(String message) {
        alerts.add(new Alert(message));
    }

    public List<Alert> getAlerts() {
        return new ArrayList<>(alerts); // Return a copy to prevent modification
    }
}