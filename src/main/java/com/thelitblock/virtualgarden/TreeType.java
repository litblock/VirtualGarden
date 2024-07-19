package com.thelitblock.virtualgarden;

public enum TreeType {
    OAK(20),
    PINE(15),
    MAPLE(25),
    BIRCH(10),
    CHERRY(30);

    private final int cost;

    TreeType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}