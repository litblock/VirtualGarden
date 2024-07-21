package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AlertManager;

public class Vegetable extends Plant {
    private VegetableType vegetableType;
    private boolean harvestable = false;

    public Vegetable(String name, VegetableType vegetableType, AlertManager alertManager) {
        super(PlantType.VEGETABLE, vegetableType.getGrowthFactor(), alertManager);
        this.vegetableType = vegetableType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public String getName() {
        return type.toString();
    }

    public boolean isHarvestable() {
        return harvestable;
    }

    public void setHarvestable(boolean harvestable) {
        this.harvestable = harvestable;
    }
}