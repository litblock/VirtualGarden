package com.thelitblock.virtualgarden;

public class Plant {
    protected String type;
    protected int growthStage;
    protected boolean isHealthy;

    public Plant(String type) {
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

    public String getType() {
        return type;
    }
}