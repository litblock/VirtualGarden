package com.thelitblock.virtualgarden.commands;

import com.thelitblock.virtualgarden.Garden;
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
        return "Displays the current state of the garden";
    }

    @Override
    public void execute(String[] args) {
        garden.displayGarden();
    }
}