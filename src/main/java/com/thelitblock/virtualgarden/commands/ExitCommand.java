package com.thelitblock.virtualgarden.commands;

public class ExitCommand implements Command {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Exits the application";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Exiting Virtual Garden...");
        System.exit(0);
    }
}