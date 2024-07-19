package com.thelitblock.virtualgarden;

public class Vegetable extends Plant {
    private int harvestTime; // Days until harvest
    private String name;
    private VegetableType type;

    public Vegetable(String name, VegetableType type, int harvestTime) {
        super(PlantType.VEGETABLE);
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public String getName() {
        return name;
    }

    public VegetableType getVegetableType() {
        return type;
    }
}