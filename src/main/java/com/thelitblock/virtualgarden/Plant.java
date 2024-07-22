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
    private double waterFactor;
    private int turnsSinceWatering;
    private AdjustableScheduler scheduler;
    private AlertManager alertManager;


    public Plant(PlantType type, double growthFactor, AlertManager alertManager) {
        this.alertManager = alertManager;
        this.type = type;
        this.growthStage = GrowthStage.SEED;
        this.isHealthy = true;
        this.growthFactor = growthFactor;
        this.waterFactor = 30;
        this.scheduler = new AdjustableScheduler(1);
        scheduleGrowthUpdate();
    }

    private void scheduleGrowthUpdate() {
        Runnable growthUpdateTask = this::triggerGrowthUpdate;
        scheduler.scheduleTask(growthUpdateTask, 5, TimeUnit.SECONDS);
    }

    public void triggerGrowthUpdate() {
        if (growthStage != GrowthStage.DEAD) {
            if (turnsSinceWatering >= 3) {
                growthStage = GrowthStage.DEAD;
                scheduler.cancel();
                alertManager.addAlert("Alert: Plant " + type + " has died due to lack of water.");
                return;
            }
            waterFactor = Math.max(0, waterFactor - 1); //change maybe
            if (isDry()) {
                turnsSinceWatering++;
            }
            else {
                turnsSinceWatering = 0;
            }
            if (isDry()) {
                alertManager.addAlert("Alert: " + type + " is dry and needs water. Add water or the plant will stop growing or die");
            }
            else {
                GrowthStage previousStage = this.growthStage;
                boolean shouldGrow = new java.util.Random().nextDouble() < calculateGrowthProbability();
                if (shouldGrow) {
                    growthStage = GardenManager.getNextGrowthStage(growthStage, type);
                    alertManager.addAlert("Alert: Plant " + type + " has grown from " + previousStage + " to " + growthStage);
                    if (growthStage == GrowthStage.VEGETATIVE && type == PlantType.VEGETABLE) {
                        setHarvestableConditionally();
                    }
                }
                scheduleGrowthUpdate();
            }
        }
    }

    public GrowthStage getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(GrowthStage growthStage) {
        this.growthStage = growthStage;
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

    private boolean isDry() {
        alertManager.addAlert("Alert: Plant " + type + " is dry");
        return waterFactor < 3;
    }

    //currently hardcoded water factor (eventually add to enum)
    public int watering(int water) {
        int overflow = 0;
        if (waterFactor + water > 30) {
            overflow = (int) (waterFactor + water - 30);
            waterFactor = 30;
        }
        else {
            waterFactor += water;
        }
        turnsSinceWatering = 0;
        System.out.println("Watering plant: " + type + " - Water level: " + waterFactor + ". Overflow: " + overflow);
        return overflow;
    }
}