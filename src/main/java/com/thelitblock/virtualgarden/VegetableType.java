package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.items.VegetableItemType;

public enum VegetableType {
    TOMATO(7, VegetableItemType.TOMATO, 1.2),
    CARROT(5, VegetableItemType.CARROT, 1.1),
    LETTUCE(4, VegetableItemType.LETTUCE, 0.8),
    CUCUMBER(6, VegetableItemType.CUCUMBER, 1.0),
    PEPPER(8, VegetableItemType.PEPPER, 1.3);

    private final int cost;
    private final VegetableItemType itemType;
    private final double growthFactor;

    VegetableType(int cost, VegetableItemType itemType, double growthFactor) {
        this.cost = cost;
        this.itemType = itemType;
        this.growthFactor = growthFactor;
    }

    public int getCost() {
        return cost;
    }

    public VegetableItemType getItemType() {
        return itemType;
    }

    public double getGrowthFactor() {
        return growthFactor;
    }
}