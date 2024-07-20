package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.Plant;
import com.thelitblock.virtualgarden.PlantType;
import com.thelitblock.virtualgarden.GrowthStage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantGrowthTest {

    @Test
    public void testPlantGrowsAfterUpdate() {
        AlertManager alertManager = new AlertManager(); // Assuming you have an AlertManager instance
        Plant plant = new Plant(PlantType.FLOWER, 1, alertManager);

        assertEquals(GrowthStage.SEED, plant.getGrowthStage());

        plant.triggerGrowthUpdate();

        assertEquals(GardenManager.getNextGrowthStage(GrowthStage.SEED, PlantType.FLOWER), plant.getGrowthStage());
    }
}
