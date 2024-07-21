package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;
import com.thelitblock.virtualgarden.items.InventoryItem;
import com.thelitblock.virtualgarden.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlantHarvestingTest {

    private GardenManager gardenManager;
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        gardenManager = new GardenManager(new Garden(2, 2), 100);
        inventory = gardenManager.getInventory();
    }

    @Test
    public void testHarvestPlant() {
        int row = 0;
        int col = 0;
        Vegetable vegetable = new Vegetable("CarrotName", VegetableType.CARROT, gardenManager.getAlertManager()); // Use AlertManager from GardenManager
        gardenManager.addPlantWithSubType("VEGETABLE:CARROT", row, col);

        gardenManager.harvestPlant(row, col);

        assertNull(gardenManager.getGarden().getPlot().getPlantAt(row, col));
        printInventoryItems();
    }

    @Test
    public void printInventoryItems() {
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
                } else {
                    System.out.println("- " + item.getName());
                }
            });
        }
    }
}