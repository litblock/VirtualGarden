package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.commands.*;
import com.thelitblock.virtualgarden.commands.info.AlertCommand;
import com.thelitblock.virtualgarden.commands.info.DisplayCommand;
import com.thelitblock.virtualgarden.commands.info.InventoryCommand;
import com.thelitblock.virtualgarden.util.GardenManager;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class VirtualGarden {
    private static final Logger logger = LoggerFactory.getLogger(VirtualGarden.class);

    public static void main(String[] args) {
        logger.debug("Starting Virtual Garden application");
        try {
            Terminal terminal = TerminalBuilder.terminal();
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(new StringsCompleter("plant", "remove", "display", "exit"))
                    .build();

            Garden garden = new Garden(2, 2);
            int initialCurrency = 100;
            GardenManager gardenManager = new GardenManager(garden, initialCurrency);

            System.out.println("Welcome to Virtual Garden!");
            CommandRegistry commandRegistry = new CommandRegistry();
            commandRegistry.registerCommand(new PlantSeedCommand(garden, lineReader, gardenManager));
            commandRegistry.registerCommand(new RemovePlantCommand(garden, lineReader));
            commandRegistry.registerCommand(new DisplayCommand(garden, lineReader));
            commandRegistry.registerCommand(new ExitCommand());
            commandRegistry.registerCommand(new HelpCommand(commandRegistry));
            commandRegistry.registerCommand(new InventoryCommand(gardenManager));
            commandRegistry.registerCommand(new AlertCommand(gardenManager.getAlertManager(), lineReader));

            while (true) {
                String input = lineReader.readLine("Enter command (help): ");
                String[] parts = input.split(" ");
                Command cmd = commandRegistry.getCommand(parts[0]);
                if (cmd != null) {
                    cmd.execute(Arrays.copyOfRange(parts, 1, parts.length));
                }
                else {
                    System.out.println("Unknown command. Try Again");
                }
            }
        }
        catch (Exception e) {
            logger.error("An error occurred", e);
        }
    }
}