package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AlertManager;

public class Flower extends Plant {
    private FlowerType flowerType;
    private String flowerColor;

    public Flower(FlowerType flowerType, String flowerColor, AlertManager alertManager) {
        super(PlantType.FLOWER, 1, alertManager);
        this.flowerType = flowerType;
        this.flowerColor = flowerColor;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public String getName() {
        return flowerType.toString();
    }
}