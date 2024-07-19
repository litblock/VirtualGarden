package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.*;
import org.jline.reader.LineReader;

public class DisplayCommand implements Command {
    private Garden garden;
    private LineReader lineReader;

    public DisplayCommand(Garden garden, LineReader lineReader) {
        this.garden = garden;
        this.lineReader = lineReader;
    }

    @Override
    public String getName() {
        return "display";
    }

    @Override
    public String getDescription() {
        return "Displays the garden with detailed plant information including time left for growth";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Garden Layout:");
        System.out.print("    ");
        for (int col = 0; col < garden.getPlot().getCols(); col++) {
            System.out.printf("%2d ", col);
        }
        System.out.println();

        for (int row = 0; row < garden.getPlot().getRows(); row++) {
            System.out.printf("%2d  ", row);
            for (int col = 0; col < garden.getPlot().getCols(); col++) {
                Plant plant = garden.getPlot().getPlantAt(row, col);
                if (plant != null) {
                    String symbol = getSymbolForPlantType(plant.getType());
                    int growthTimeLeft = calculateGrowthTimeLeft(plant);
                    System.out.print(symbol + plant.getGrowthStage().toString().charAt(0) + "(" + growthTimeLeft + ") "); // Append growth stage initial and time left
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
        printLegend();
    }

    private String getSymbolForPlantType(PlantType plantType) {
        switch (plantType) {
            case FLOWER: return "F";
            case TREE: return "T";
            case VEGETABLE: return "V";
            default: return "?";
        }
    }

    private int calculateGrowthTimeLeft(Plant plant) {
        final int updateFrequencyInMinutes = 15; // Assuming updates occur every 15 minutes
        int currentGrowthStage = plant.getGrowthStage().ordinal();
        int maxGrowthStage = plant.getMaxGrowthStage(); // Assuming this method exists and returns the max growth stage for a plant
        int stagesLeft = maxGrowthStage - currentGrowthStage;

        // Calculate total time left in minutes
        int totalTimeLeftInMinutes = stagesLeft * updateFrequencyInMinutes;

        // Optionally, convert minutes to a more readable format (e.g., days) if needed
        // Here, simply returning the time left in minutes
        return totalTimeLeftInMinutes;
    }

    private void printLegend() {
        System.out.println("\nLegend:");
        System.out.println("F - Flower");
        System.out.println("T - Tree");
        System.out.println("V - Vegetable");
        System.out.println(". - Empty Plot");
        System.out.println("Number in parentheses indicates days left for growth");
    }
}