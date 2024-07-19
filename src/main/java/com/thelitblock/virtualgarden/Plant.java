package com.thelitblock.virtualgarden;

public class Plant {
    protected PlantType type;
    protected int growthStage;
    protected boolean isHealthy;

    public Plant(PlantType type) {
        this.type = type;
        this.growthStage = 0;
        this.isHealthy = true;
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
}