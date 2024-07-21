package com.thelitblock.virtualgarden.items;

import com.thelitblock.virtualgarden.PlantType;

public class SeedItem extends Item {
    private PlantType plantType;

    public SeedItem(String id, String name, String description, PlantType plantType, int quantity) {
        super(id, name, description, quantity, true);
        this.plantType = plantType;
    }

    public PlantType getPlantType() {
        return plantType;
    }
}