package com.thelitblock.virtualgarden;

public class Plot {
    private Plant[][] plotGrid;
    private int rows;
    private int cols;

    public Plot(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.plotGrid = new Plant[rows][cols];
    }

    public void addPlant(int row, int col, Plant plant) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            plotGrid[row][col] = plant;
        }
    }

    public void removePlant(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            plotGrid[row][col] = null;
        }
    }

    public void displayPlot() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (plotGrid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(plotGrid[i][j].getType().toString().substring(0, 1).toUpperCase() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isPlantAt(int row, int col, Plant plant) {
        if (row >= 0 && row < this.rows && col >= 0 && col < this.cols) {
            Plant existingPlant = this.plotGrid[row][col];
            return existingPlant != null && existingPlant.equals(plant);
        }
        return false;
    }
}