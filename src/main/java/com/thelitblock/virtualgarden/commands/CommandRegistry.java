package com.thelitblock.virtualgarden.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}