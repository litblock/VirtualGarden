package com.thelitblock.virtualgarden;

public class Flower extends Plant {
    private String flowerColor;

    public Flower(String type, String flowerColor) {
        super(type);
        this.flowerColor = flowerColor;
    }

    public String getFlowerColor() {
        return flowerColor;
    }
}