package com.thelitblock.virtualgarden;

public enum FlowerType {
    ROSE(15),
    TULIP(12),
    DAISY(8);

    private final int cost;

    FlowerType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}