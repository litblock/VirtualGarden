package com.thelitblock.virtualgarden;

public enum FlowerType {
    ROSE(15, 0.5),
    TULIP(12, 0.4),
    DAISY(8, 0.3),
    SUNFLOWER(20, 0.6),
    LILY(10, 0.35);

    private final int cost;
    private final double growthFactor;

    FlowerType(int cost, double growthFactor) {
        this.cost = cost;
        this.growthFactor = growthFactor;
    }

    public int getCost() {
        return cost;
    }

    public double getGrowthFactor() {
        return growthFactor;
    }
}