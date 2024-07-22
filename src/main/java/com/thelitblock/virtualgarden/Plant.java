package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AdjustableScheduler;
import com.thelitblock.virtualgarden.util.AlertManager;
import com.thelitblock.virtualgarden.util.GardenManager;

import java.util.concurrent.TimeUnit;

public class Plant {
    protected PlantType type;
    private GrowthStage growthStage;
    protected boolean isHealthy;
    private double growthFactor;
    private AdjustableScheduler scheduler;
    private AlertManager alertManager;


    public Plant(PlantType type, double growthFactor, AlertManager alertManager) {
        this.alertManager = alertManager;
        this.type = type;
        this.growthStage = GrowthStage.SEED;
        this.isHealthy = true;
        this.growthFactor = growthFactor;
        this.scheduler = new AdjustableScheduler(1);
        scheduleGrowthUpdate();
    }

    private void scheduleGrowthUpdate() {
        Runnable growthUpdateTask = this::triggerGrowthUpdate;
        scheduler.scheduleTask(growthUpdateTask, 10, TimeUnit.SECONDS);
    }

    public void triggerGrowthUpdate() {
        if (growthStage == GrowthStage.DEAD) {
            scheduler.cancel();
        }
        else {
            GrowthStage previousStage = this.growthStage;
            boolean shouldGrow = new java.util.Random().nextDouble() < calculateGrowthProbability();
            if (shouldGrow) {
                growthStage = GardenManager.getNextGrowthStage(growthStage, type);
            }
            if (previousStage != growthStage) {
                alertManager.addAlert("Alert: Plant " + type + " has grown from " + previousStage + " to " + growthStage);
                if (growthStage == GrowthStage.VEGETATIVE && type == PlantType.VEGETABLE) {
                    setHarvestableConditionally();
                }
                if (growthStage != GrowthStage.DEAD) {
                    scheduleGrowthUpdate();
                }
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

    private double calculateGrowthProbability() {
        return 0.5 + (growthFactor / 100.0);
    }
    private void setHarvestableConditionally() {
    if (this instanceof Vegetable) {
        ((Vegetable) this).setHarvestable(true);
    }
}
}