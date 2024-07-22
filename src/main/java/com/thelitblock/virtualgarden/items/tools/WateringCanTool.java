package com.thelitblock.virtualgarden.items.tools;

import com.thelitblock.virtualgarden.Plant;

public class WateringCanTool extends ToolItem {
    private int waterLevel;
    private final int maxWaterLevel;

    public WateringCanTool(String id, String name, String description, ToolType type, int quantity, boolean isStackable, int maxWaterLevel) {
        super(id, name, description, type, quantity, isStackable);
        this.maxWaterLevel = maxWaterLevel;
        this.waterLevel = maxWaterLevel;
    }

    public void waterPlant(Plant plant) {
        if (this.waterLevel > 0) {
            waterLevel = plant.watering(waterLevel);
            System.out.println("Watered " + plant.getType() + ". Water level in can now: " + this.waterLevel);
        }
        else {
            System.out.println("The watering can is empty. Please refill it.");
        }
    }

    public void refill() {
        this.waterLevel = this.maxWaterLevel;
        System.out.println("Watering can refilled. Water level is now: " + this.maxWaterLevel);
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }
}