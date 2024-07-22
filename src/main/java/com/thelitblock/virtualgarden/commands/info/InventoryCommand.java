package com.thelitblock.virtualgarden.commands.info;

import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.items.Item;
import com.thelitblock.virtualgarden.util.GardenManager;
import com.thelitblock.virtualgarden.items.InventoryItem;
import java.util.Map;

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
        return "Displays the items in the inventory";
    }

    @Override
    public void execute(String[] args) {
        Map<String, InventoryItem> items = gardenManager.getInventoryItems();
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        }
        else {
            System.out.println("Your inventory contains:");
            items.forEach((id, item) -> {
                if (item instanceof Item) {
                    Item castedItem = (Item) item;
                    int quantity = castedItem.isStackable() ? castedItem.getQuantity() : 1;
                    System.out.println("- " + castedItem.getName() + " (Quantity: " + quantity + ")");
                }
                else {
                    System.out.println("- " + item.getName());
                }
            });
        }
    }
}