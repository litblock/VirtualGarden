package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.Plant;
import com.thelitblock.virtualgarden.PlantType;
import com.thelitblock.virtualgarden.GrowthStage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantGrowthTest {

    @Test
    public void testPlantGrowsAfterUpdate() {
        Plant plant = new Plant(PlantType.FLOWER, 1);

        assertEquals(GrowthStage.SEED, plant.getGrowthStage());

        plant.triggerGrowthUpdate();

        assertEquals(GardenManager.getNextGrowthStage(GrowthStage.SEED, PlantType.FLOWER), plant.getGrowthStage());
    }
}
