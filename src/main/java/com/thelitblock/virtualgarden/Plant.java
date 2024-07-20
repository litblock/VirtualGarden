package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AdjustableScheduler;
import com.thelitblock.virtualgarden.util.GardenManager;

import java.util.concurrent.TimeUnit;

public class Plant {
    protected PlantType type;
    private GrowthStage growthStage;
    protected boolean isHealthy;
    private int growthFactor;
    private AdjustableScheduler scheduler;

    public Plant(PlantType type, int growthFactor) {
        this.type = type;
        this.growthStage = GrowthStage.SEED;
        this.isHealthy = true;
        this.growthFactor = growthFactor;
        this.scheduler = new AdjustableScheduler(growthFactor);
        scheduleGrowthUpdate();
    }

    private void scheduleGrowthUpdate() {
        Runnable growthUpdateTask = this::triggerGrowthUpdate;
        scheduler.scheduleTask(growthUpdateTask, growthFactor, TimeUnit.MINUTES);
    }

    public void triggerGrowthUpdate() {
        if (growthStage == GrowthStage.DEAD) {
            scheduler.cancel();
        } else {
            GrowthStage previousStage = this.growthStage;
            growthStage = GardenManager.getNextGrowthStage(growthStage, type);
            if (previousStage != growthStage) {
                System.out.println("Alert: Plant " + type + " has grown from " + previousStage + " to " + growthStage);
            }
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