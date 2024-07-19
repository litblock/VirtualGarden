package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.GardenManager;

public class Plant {
    protected PlantType type;
    private GrowthStage growthStage;
    protected boolean isHealthy;
    private int growthFactor; // New attribute
    private int growthCounter = 0;

    public Plant(PlantType type, int growthFactor) {
        this.type = type;
        this.growthStage = GrowthStage.SEED;
        this.isHealthy = true;
        this.growthFactor = growthFactor;
    }

    public void updateGrowth(GardenManager gardenManager) {
        growthCounter++;
        if (growthCounter >= growthFactor) {
            gardenManager.updateIndividualPlantGrowth(this);
            growthCounter = 0;
        }
    }

    public GrowthStage getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(GrowthStage growthStage) {
        this.growthStage = growthStage;
    }

    public void water() {
    }

    public void giveSunlight() {

    }

    @Override
    public String toString() {
        return type + " - Stage: " + growthStage + ", Healthy: " + isHealthy;
    }

    public PlantType getType() {
        return type;
    }

    public int getMaxGrowthStage() {
        return type.getMaxGrowthStage();
    }
}