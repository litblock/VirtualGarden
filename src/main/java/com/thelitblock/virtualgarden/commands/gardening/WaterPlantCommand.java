package com.thelitblock.virtualgarden.commands.gardening;

import com.thelitblock.virtualgarden.Garden;
import com.thelitblock.virtualgarden.Plant;
import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.items.tools.ToolItem;
import com.thelitblock.virtualgarden.items.tools.WateringCanTool;
import com.thelitblock.virtualgarden.util.GardenManager;
import org.jline.reader.LineReader;

public class WaterPlantCommand implements Command {
    private GardenManager gardenManager;
    public LineReader lineReader;

    public WaterPlantCommand(GardenManager gardenManager, LineReader lineReader) {
        this.gardenManager = gardenManager;
        this.lineReader = lineReader;
    }

    @Override
    public String getName() {
        return "WaterPlant";
    }

    @Override
    public String getDescription() {
        return "Water a plant";
    }

    @Override
    public void execute() {
        int row, col;
        String tool;
        tool = lineReader.readLine("Enter watering can you would like to use");
        row = Integer.parseInt(lineReader.readLine("Enter row: "));
        col = Integer.parseInt(lineReader.readLine("Enter column: "));
        Plant plant = gardenManager.getGarden().getPlot().getPlantAt(row, col);
        WateringCanTool wateringCan = (WateringCanTool) gardenManager.getInventory().getTool(tool);
        if (plant == null) {
            System.out.println("No plant found at the specified location.");
            return;
        }
        if (wateringCan.getWaterLevel() > 0) {
            wateringCan.waterPlant(plant);
            System.out.println("Watered " + plant.getType() + " at (" + row + ", " + col + "). Water level in can now: " + wateringCan.getWaterLevel());
        }
        else {
            System.out.println("The watering can is empty. Please refill it.");
        }
    }
}