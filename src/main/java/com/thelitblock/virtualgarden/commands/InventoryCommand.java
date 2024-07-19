package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.util.GardenManager;

public class InventoryCommand implements Command {
    private GardenManager gardenManager;

    public InventoryCommand(GardenManager gardenManager) {
        this.gardenManager = gardenManager;
    }

    @Override
    public String getName() {
        return "inventory";
    }

    @Override
    public String getDescription() {
        return "Displays the current number of coins";
    }

    @Override
    public void execute(String[] args) {
        int coins = gardenManager.getCurrencyBalance();
        System.out.println("You currently have " + coins + " coins.");
    }
}