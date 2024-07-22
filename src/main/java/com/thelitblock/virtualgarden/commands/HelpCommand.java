package com.thelitblock.virtualgarden.commands;

import java.util.Map;

public class HelpCommand implements Command {
    private CommandRegistry commandRegistry;

    public HelpCommand(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Displays help information for available commands";
    }

    @Override
    public void execute() {
        System.out.println("Available commands:");
        for (Map.Entry<String, Command> entry : commandRegistry.getCommands().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getDescription());
        }
    }
}