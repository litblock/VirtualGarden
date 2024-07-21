package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.items.VegetableItemType;

public enum VegetableType {
    TOMATO(7, VegetableItemType.TOMATO),
    CARROT(5, VegetableItemType.CARROT),
    LETTUCE(4, VegetableItemType.LETTUCE),
    CUCUMBER(6, VegetableItemType.CUCUMBER),
    PEPPER(8, VegetableItemType.PEPPER);

    private final int cost;
    private final VegetableItemType itemType;

    VegetableType(int cost, VegetableItemType itemType) {
        this.cost = cost;
        this.itemType = itemType;
    }

    public int getCost() {
        return cost;
    }

    public VegetableItemType getItemType() {
        return itemType;
    }
}