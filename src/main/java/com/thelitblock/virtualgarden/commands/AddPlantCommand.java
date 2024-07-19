package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.Garden;
import com.thelitblock.virtualgarden.Plant;
import org.jline.reader.LineReader;

import java.util.Scanner;

public class AddPlantCommand implements Command {
    private Garden garden;
    private LineReader lineReader;

    public AddPlantCommand(Garden garden, LineReader lineReader) {
        this.garden = garden;
        this.lineReader = lineReader;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "Adds a plant to the garden";
    }

    @Override
    public void execute(String[] args) {
        String type;
        int row, col;

        if (args.length < 3) {
            type = lineReader.readLine("Enter plant type: ");
            row = Integer.parseInt(lineReader.readLine("Enter row: "));
            col = Integer.parseInt(lineReader.readLine("Enter column: "));
        }
        else {
            type = args[0];
            row = Integer.parseInt(args[1]);
            col = Integer.parseInt(args[2]);
        }

        garden.addPlant(new Plant(type), row, col);
        System.out.println("Added plant of type " + type + " at position " + row + "," + col);
    }
}