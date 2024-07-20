package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AlertManager;

public class Vegetable extends Plant {
    private int harvestTime; // Days until harvest
    private VegetableType vegetableType;

    public Vegetable(String name, VegetableType vegetableType, int harvestTime, AlertManager alertManager) {
        super(PlantType.VEGETABLE, 1, alertManager);
        this.vegetableType = vegetableType;
        this.harvestTime = harvestTime;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public String getName() {
        return type.toString();
    }
}