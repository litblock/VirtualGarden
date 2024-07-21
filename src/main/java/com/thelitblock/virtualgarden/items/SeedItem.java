package com.thelitblock.virtualgarden.items;

import com.thelitblock.virtualgarden.PlantType;

public class SeedItem extends HarvestableItem {
    private PlantType plantType;

    public SeedItem(String id, String name, String description, PlantType plantType, int quantity, boolean isStackable) {
        super(HarvestableItemType.SEEDITEM, id, name, description, quantity, isStackable);
        this.plantType = plantType;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    @Override
    public void harvest() {

    }
}