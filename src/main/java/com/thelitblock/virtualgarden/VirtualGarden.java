package com.thelitblock.virtualgarden;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualGarden {
    private static final Logger logger = LoggerFactory.getLogger(VirtualGarden.class);

    public static void main(String[] args) {
        logger.debug("Starting Virtual Garden application");
        try {
            Terminal terminal = TerminalBuilder.terminal();
            //logger.debug("Terminal initialized");
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(new StringsCompleter("add", "remove", "display", "exit"))
                    .build();
            //logger.debug("LineReader with command completer initialized");

            Garden garden = new Garden(5, 5);
            //logger.debug("Garden instance created");
            String command;

            System.out.println("Welcome to Virtual Garden!");
            while (true) {
                command = lineReader.readLine("Enter command (add, remove, display, exit): ");
                //logger.debug("Received command: {}", command);

                switch (command) {
                    case "add":
                        System.out.println("Enter plant type, row, and column:");
                        String type = lineReader.readLine("Type: ");
                        int row = Integer.parseInt(lineReader.readLine("Row: "));
                        int col = Integer.parseInt(lineReader.readLine("Column: "));
                        garden.addPlant(new Plant(type), row, col);
                        //logger.debug("Added plant of type {} at position {},{}", type, row, col);
                        break;
                    case "remove":
                        System.out.println("Enter plant type, row, and column to remove:");
                        type = lineReader.readLine("Type: ");
                        row = Integer.parseInt(lineReader.readLine("Row: "));
                        col = Integer.parseInt(lineReader.readLine("Column: "));
                        garden.removePlant(type, row, col);
                        //logger.debug("Removed plant of type {} from position {},{}", type, row, col);
                        break;
                    case "display":
                        garden.displayGarden();
                        //logger.debug("Displayed garden");
                        break;
                    case "exit":
                        System.out.println("Exiting Virtual Garden.");
                        //logger.debug("Exiting application");
                        return;
                    default:
                        System.out.println("Unknown command. Try Again");
                        //logger.warn("Received unknown command: {}", command);
                        break;
                }
            }
        }
        catch (Exception e) {
            logger.error("An error occurred", e);
        }
    }
}