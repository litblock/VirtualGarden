package com.thelitblock.virtualgarden;

public enum VegetableType {
    TOMATO(7),
    CARROT(5),
    LETTUCE(4),
    CUCUMBER(6),
    PEPPER(8);

    private final int cost;

    VegetableType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}