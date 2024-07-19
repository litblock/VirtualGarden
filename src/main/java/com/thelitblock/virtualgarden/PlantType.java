package com.thelitblock.virtualgarden;

public enum PlantType {
    FLOWER(10),
    TREE(20),
    VEGETABLE(5);

    private final int cost;

    PlantType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getMaxGrowthStage() {
        switch (this) {
            case FLOWER: return 4;
            case TREE: return 5;
            case VEGETABLE: return 4;
            default: return 0;
        }
    }
}