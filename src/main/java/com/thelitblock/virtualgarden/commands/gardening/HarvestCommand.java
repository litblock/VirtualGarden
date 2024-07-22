package com.thelitblock.virtualgarden.commands.gardening;

import com.thelitblock.virtualgarden.Garden;
import com.thelitblock.virtualgarden.Plant;
import com.thelitblock.virtualgarden.Vegetable;
import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.items.HarvestableItem;
import com.thelitblock.virtualgarden.util.GardenManager;
import org.jline.reader.LineReader;

public class HarvestCommand implements Command {
    private Garden garden;
    private LineReader lineReader;
    private GardenManager gardenManager;

    public HarvestCommand(Garden garden, LineReader lineReader, GardenManager gardenManager) {
        this.garden = garden;
        this.lineReader = lineReader;
        this.gardenManager = gardenManager;
    }

    public String getName() {
        return "harvest";
    }

    public String getDescription() {
        return "Harvests a plant from the garden based on its position";
    }

    public void execute() {
        System.out.println("Please specify the row of the plant to harvest:");
        String rowInput = lineReader.readLine();
        int row = Integer.parseInt(rowInput);

        System.out.println("Please specify the column of the plant to harvest:");
        String columnInput = lineReader.readLine();
        int column = Integer.parseInt(columnInput);

        Plant plant = gardenManager.getGarden().getPlot().getPlantAt(row, column);

        if (plant == null) {
            System.out.println("Plant not found.");
            return;
        }

        boolean isHarvestable = false;
        //only vegetables for now
        if (plant instanceof Vegetable) {
            isHarvestable = ((Vegetable) plant).isHarvestable();
        }

        if (isHarvestable) {
            gardenManager.harvestPlant(row, column);
            System.out.println("Plant harvested successfully.");
        }
        else {
            System.out.println("Plant is not ready for harvest.");
        }
    }
}