package com.thelitblock.virtualgarden.commands.gardening;

import com.thelitblock.virtualgarden.*;
import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.util.GardenManager;
import org.jline.reader.LineReader;

public class PlantSeedCommand implements Command {
    private Garden garden;
    private LineReader lineReader;
    private GardenManager gardenManager;

    public PlantSeedCommand(Garden garden, LineReader lineReader, GardenManager gardenManager) {
        this.garden = garden;
        this.lineReader = lineReader;
        this.gardenManager = gardenManager;
    }

    @Override
    public String getName() {
        return "plant";
    }

    @Override
    public String getDescription() {
        return "Plants a seed to the garden";
    }

    @Override
    public void execute(String[] args) {
        String plantTypeInput = lineReader.readLine("Enter plant type (Flower, Tree, Vegetable): ");
        PlantType plantType;
        try {
            plantType = PlantType.valueOf(plantTypeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Plant type " + plantTypeInput + " is not recognized.");
            return;
        }

        String subTypeInput = "";
        int cost = plantType.getCost(); // Base cost from PlantType

        switch (plantType) {
            case FLOWER:
                subTypeInput = lineReader.readLine("Enter flower type (Rose, Tulip, Daisy, Sunflower, Lily): ");
                cost += FlowerType.valueOf(subTypeInput.toUpperCase()).getCost();
                break;
            case TREE:
                subTypeInput = lineReader.readLine("Enter tree type (Oak, Pine, Maple, Birch, Cherry): ");
                cost += TreeType.valueOf(subTypeInput.toUpperCase()).getCost();
                break;
            case VEGETABLE:
                subTypeInput = lineReader.readLine("Enter vegetable type (Carrot, Pepper, Tomato, Lettuce, Cucumber): ");
                cost += VegetableType.valueOf(subTypeInput.toUpperCase()).getCost();
                break;
        }

        if (!gardenManager.isValidSubType(subTypeInput, plantType)) {
            System.out.println("Error: " + plantType.name() + " type " + subTypeInput + " is not recognized.");
            return;
        }

        if (!gardenManager.canAfford(cost)) {
            System.out.println("Error: Not enough coins to plant " + subTypeInput + ".");
            return;
        }

        int row = Integer.parseInt(lineReader.readLine("Enter row: "));
        int col = Integer.parseInt(lineReader.readLine("Enter column: "));

        if (row < 0 || row >= garden.getPlot().getRows() || col < 0 || col >= garden.getPlot().getCols()) {
            System.out.println("Error: The specified coordinates are out of the garden's bounds.");
            return;
        }

        if (garden.getPlot().isPlantAt(row, col)) {
            System.out.println("Error: Tile at position " + row + "," + col + " is already occupied by another plant.");
            return;
        }

        gardenManager.spendCurrency(cost);
        String combinedType = plantType.name() + ":" + subTypeInput.toUpperCase();
        gardenManager.addPlantWithSubType(combinedType, row, col);
        System.out.println("Planted " + subTypeInput + " of type " + plantTypeInput + " at position " + row + "," + col + ". Cost: " + cost + " coins.");
    }
}