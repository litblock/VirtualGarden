package com.thelitblock.virtualgarden;

public enum TreeType {
    OAK(20, 0.5),
    PINE(15, 0.2),
    MAPLE(25, 0.3),
    BIRCH(10, 0.1),
    CHERRY(30, 0.4);

    private final int cost;
    private final double growthFactor;

    TreeType(int cost, double growthFactor) {
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