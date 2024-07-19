package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GardenManager {
    private List<Plant> plants = new ArrayList<>();

    public void addPlant(PlantType type, String name, int harvestTime) {
        if (EnumSet.allOf(PlantType.class).contains(type)) {
            Plant plant = createPlant(type, name, harvestTime);
            if (plant != null) {
                plants.add(plant);
                System.out.println("Added plant of type: " + type + " with name: " + name);
            }
        } else {
            System.out.println("Error: Plant type " + type + " is not available.");
        }
    }

    private Plant createPlant(PlantType type, String name, int harvestTime) {
        switch (type) {
            case VEGETABLE:
                return new Vegetable(name, VegetableType.valueOf(name.toUpperCase()), harvestTime);
            case FLOWER:
                // flower
                return null;
            case TREE:
                // tree
                return null;
            default:
                System.out.println("Unsupported plant type: " + type);
                return null;
        }
    }
}