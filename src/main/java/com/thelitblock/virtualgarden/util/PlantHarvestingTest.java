package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        assertTrue(inventory.hasItemOfType("CARROT"));
        assertEquals(1, inventory.countItemsOfType("CARROT"));
    }
}