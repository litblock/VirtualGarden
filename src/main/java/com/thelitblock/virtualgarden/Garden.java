package com.thelitblock.virtualgarden;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garden {
    private final List<Plant> plants = new ArrayList<>();
    private final Plot plot;

    public Garden(int rows, int cols) {
        this.plot = new Plot(rows, cols);
    }

    public void addPlant(Plant plant, int row, int col) {
        plants.add(plant);
        plot.addPlant(row, col, plant);
    }

    public void removePlant(String plantType, int row, int col) {
        plants.removeIf(plant -> {
            boolean isMatch = Objects.equals(plant.getType(), plantType);
            if (isMatch) {
                plot.removePlant(row, col);
            }
            return isMatch;
        });
    }

    public void displayGarden() {
        plot.displayPlot();
    }

    public Plot getPlot() {
        return plot;
    }
}