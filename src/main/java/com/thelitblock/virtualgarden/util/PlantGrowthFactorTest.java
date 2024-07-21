package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.Plant;
import com.thelitblock.virtualgarden.PlantType;
import com.thelitblock.virtualgarden.GrowthStage;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlantGrowthFactorTest {

    @RepeatedTest(10)
    public void testLowGrowthFactor() {
        AlertManager alertManager = new AlertManager();
        Plant plant = new Plant(PlantType.FLOWER, 0.5, alertManager);
        GrowthStage initialStage = plant.getGrowthStage();
        plant.triggerGrowthUpdate();
        GrowthStage newStage = plant.getGrowthStage();

        if (!initialStage.equals(newStage)) {
            System.out.println("Growth stage changed from " + initialStage + " to " + newStage);
        }

        //assertTrue(newStage == GrowthStage.SEED || newStage == GrowthStage.SPROUT);
    }

    @RepeatedTest(10)
    public void testHighGrowthFactor() {
        AlertManager alertManager = new AlertManager();
        Plant plant = new Plant(PlantType.FLOWER, 50, alertManager);
        GrowthStage initialStage = plant.getGrowthStage();
        plant.triggerGrowthUpdate();
        GrowthStage newStage = plant.getGrowthStage();

        if (!initialStage.equals(newStage)) {
            System.out.println("Growth stage changed from " + initialStage + " to " + newStage);
        }

        assertTrue(newStage != GrowthStage.SEED);
    }
}