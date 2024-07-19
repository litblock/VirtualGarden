package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;

import java.util.ArrayList;
import java.util.List;

public class GardenManager {
    private List<Plant> plants = new ArrayList<>();
    private Garden garden;

    public GardenManager(Garden garden) {
        this.garden = garden;
    }

    public void addPlantWithSubType(String subTypeInput, int row, int col) {
        Plant plant = null;
        String[] parts = subTypeInput.split(":");
        if (parts.length != 2) {
            System.out.println("Error: Invalid subtype input format.");
            return;
        }
        String plantTypeStr = parts[0].toUpperCase();
        String subTypeStr = parts[1].toUpperCase();

        try {
            PlantType plantType = PlantType.valueOf(plantTypeStr);
            switch (plantType) {
                case FLOWER:
                    FlowerType flowerType = FlowerType.valueOf(subTypeStr);
                    plant = new Flower(flowerType, "Flower Name");
                    break;
                case TREE:
                    TreeType treeType = TreeType.valueOf(subTypeStr);
                    plant = new Tree(treeType, 5);
                    break;
                case VEGETABLE:
                    VegetableType vegetableType = VegetableType.valueOf(subTypeStr);
                    plant = new Vegetable("Vegetable Name", vegetableType, 0);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid plant type or subtype.");
            return;
        }

        if (plant != null) {
            garden.addPlant(plant, row, col);
            System.out.println("Added " + plant.getClass().getSimpleName() + " to the garden at " + row + "," + col);
        }
    }

    public boolean isValidSubType(String subTypeInput, PlantType plantType) {
        try {
            switch (plantType) {
                case FLOWER:
                    FlowerType.valueOf(subTypeInput.toUpperCase());
                    break;
                case TREE:
                    TreeType.valueOf(subTypeInput.toUpperCase());
                    break;
                case VEGETABLE:
                    VegetableType.valueOf(subTypeInput.toUpperCase());
                    break;
                default:
                    return false;
            }
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}