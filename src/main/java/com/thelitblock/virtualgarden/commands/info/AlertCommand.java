package com.thelitblock.virtualgarden.commands.info;

import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.util.Alert;
import com.thelitblock.virtualgarden.util.AlertManager;
import org.jline.reader.LineReader;

import java.util.List;

public class AlertCommand implements Command {
    private final AlertManager alertManager;
    private final LineReader lineReader;

    public AlertCommand(AlertManager alertManager, LineReader lineReader) {
        this.alertManager = alertManager;
        this.lineReader = lineReader;
    }

    @Override
    public String getName() {
        return "alerts";
    }

    @Override
    public String getDescription() {
        return "Displays all alerts";
    }

    @Override
    public void execute(String[] args) {
        List<Alert> alerts = alertManager.getAlerts();
        if (alerts.isEmpty()) {
            System.out.println("No alerts.");
        } else {
            for (Alert alert : alerts) {
                System.out.println(alert.getMessage() + " - Timestamp: " + alert.getTimestamp());
            }
        }
    }
}