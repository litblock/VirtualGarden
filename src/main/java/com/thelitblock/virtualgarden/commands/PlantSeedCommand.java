package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.*;
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

        switch (plantType) {
            case FLOWER:
                System.out.println("Enter flower type (Rose, Tulip, Daisy, Sunflower, Lily): ");
                break;
            case TREE:
                System.out.println("Enter tree type (Oak, Pine, Maple, Birch, Cherry): ");
                break;
            case VEGETABLE:
                System.out.println("Enter vegetable type (Carrot, Potato, Tomato, Lettuce, Cucumber): ");
                break;
        }

        String subTypeInput = lineReader.readLine();
        if (!gardenManager.isValidSubType(subTypeInput, plantType)) {
            System.out.println("Error: " + plantType.name() + " type " + subTypeInput + " is not recognized.");
            return;
        }

        int row = Integer.parseInt(lineReader.readLine("Enter row: "));
        int col = Integer.parseInt(lineReader.readLine("Enter column: "));

        if (garden.getPlot().isPlantAt(row, col)) {
            System.out.println("Error: Tile at position " + row + "," + col + " is already occupied by another plant.");
            return;
        }

        String combinedType = plantType.name() + ":" + subTypeInput.toUpperCase();
        gardenManager.addPlantWithSubType(combinedType, row, col);
        System.out.println("Planted " + subTypeInput + " of type " + plantTypeInput + " at position " + row + "," + col);
    }
}