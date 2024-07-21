package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AlertManager;

public class Vegetable extends Plant {
    private VegetableType vegetableType;

    public Vegetable(String name, VegetableType vegetableType, AlertManager alertManager) {
        super(PlantType.VEGETABLE, 1, alertManager);
        this.vegetableType = vegetableType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public String getName() {
        return type.toString();
    }

    public boolean isHarvestable() {
        if (getGrowthStage().equals(GrowthStage.VEGETATIVE)) {
            return true;
        }
        return false;
    }
}