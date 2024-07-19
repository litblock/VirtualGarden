package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.*;
import com.thelitblock.virtualgarden.util.GardenManager;
import org.jline.reader.LineReader;

public class PlantSeedCommand implements Command {
    private Garden garden;
    private LineReader lineReader;
    private GardenManager gardenManager; // Add this line

    public PlantSeedCommand(Garden garden, LineReader lineReader, GardenManager gardenManager) { // Update constructor
        this.garden = garden;
        this.lineReader = lineReader;
        this.gardenManager = gardenManager; // Initialize gardenManager
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
        String typeName;
        int row, col;

        if (args.length < 3) {
            typeName = lineReader.readLine("Enter plant type: ");
            row = Integer.parseInt(lineReader.readLine("Enter row: "));
            col = Integer.parseInt(lineReader.readLine("Enter column: "));
        }
        else {
            typeName = args[0];
            row = Integer.parseInt(args[1]);
            col = Integer.parseInt(args[2]);
        }

        try {
            PlantType type = PlantType.valueOf(typeName.toUpperCase());
            gardenManager.addPlant(type, typeName, 0); // Assuming harvestTime is not relevant here
            System.out.println("Planted seed of type " + typeName + " at position " + row + "," + col);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: Plant type " + typeName + " is not recognized.");
        }
    }
}