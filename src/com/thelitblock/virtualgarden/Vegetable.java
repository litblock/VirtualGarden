package com.thelitblock.virtualgarden;

public class Vegetable extends Plant {
    private int harvestTime; // Days until harvest

    public Vegetable(String type, int harvestTime) {
        super(type);
        this.harvestTime = harvestTime;
    }

    public int getHarvestTime() {
        return harvestTime;
    }
}