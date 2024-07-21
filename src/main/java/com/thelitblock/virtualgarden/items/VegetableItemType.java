package com.thelitblock.virtualgarden.items;

import com.thelitblock.virtualgarden.VegetableType;

public enum VegetableItemType {
    TOMATO(VegetableType.TOMATO),
    CARROT(VegetableType.CARROT),
    LETTUCE(VegetableType.LETTUCE),
    CUCUMBER(VegetableType.CUCUMBER),
    PEPPER(VegetableType.PEPPER);

    private final VegetableType vegetableType;

    VegetableItemType(VegetableType vegetableType) {
        this.vegetableType = vegetableType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }
}