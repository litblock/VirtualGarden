package com.thelitblock.virtualgarden.commands.gardening;

import com.thelitblock.virtualgarden.Garden;
import com.thelitblock.virtualgarden.commands.Command;
import org.jline.reader.LineReader;

public class RemovePlantCommand implements Command {
    private Garden garden;
    private LineReader lineReader;

    public RemovePlantCommand(Garden garden, LineReader lineReader) {
        this.garden = garden;
        this.lineReader = lineReader;
    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "Removes a plant from the garden based on its position";
    }

    @Override
    public void execute() {
        String type;
        int row, col;

        type = lineReader.readLine("Enter plant type: ");
        row = Integer.parseInt(lineReader.readLine("Enter row: "));
        col = Integer.parseInt(lineReader.readLine("Enter column: "));

        boolean success = garden.removePlant(type, row, col);
        if (success) {
            System.out.println("Plant of type " + type + " removed successfully from position " + row + "," + col);
        }
        else {
            System.out.println("No plant of type " + type + " found at the specified position.");
        }
    }
}