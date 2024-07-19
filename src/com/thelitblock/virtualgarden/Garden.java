package com.thelitblock.virtualgarden;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private final List<Plant> plants = new ArrayList<>();

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(String plantType) {
        for (Plant plant : plants) {
            if (plant.getType().equals(plantType)) {
                plants.remove(plant);
                return;
            }
        }
    }

    public void displayGarden() {
        for (Plant plant : plants) {
            System.out.println(plant);
        }
    }
}
