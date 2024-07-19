package com.thelitblock.virtualgarden;

public class Plant {
    private String type; //implement ltr
    private int growthStage; //implement ltr
    private boolean isHealthy; //implment ltr

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

    public Object getType() {
        return type;
    }
}