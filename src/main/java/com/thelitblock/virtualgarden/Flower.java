package com.thelitblock.virtualgarden;

public class Flower extends Plant {
    private FlowerType flowerType;
    private String flowerColor;

    public Flower(FlowerType flowerType, String flowerColor) {
        super(PlantType.FLOWER);
        this.flowerType = flowerType;
        this.flowerColor = flowerColor;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public String getFlowerColor() {
        return flowerColor;
    }
}