package com.thelitblock.virtualgarden;

public class Plant {
    protected PlantType type;
    private GrowthStage growthStage;
    protected boolean isHealthy;

    public Plant(PlantType type) {
        this.type = type;
        this.growthStage = GrowthStage.SEED;
        this.isHealthy = true;
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
}