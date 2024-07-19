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

    public boolean removePlant(String plantType, int row, int col) {
        boolean removed = false;
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            if (Objects.equals(plant.getType(), plantType) && plot.isPlantAt(row, col)) {
                plants.remove(plant);
                plot.removePlant(row, col);
                removed = true;
                break;
            }
        }
        return removed;
    }

    public void displayGarden() {
        plot.displayPlot();
    }

    public Plot getPlot() {
        return plot;
    }
}