package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.commands.Command;
import com.thelitblock.virtualgarden.commands.DisplayCommand;
import com.thelitblock.virtualgarden.commands.ExitCommand;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thelitblock.virtualgarden.commands.CommandRegistry;
import com.thelitblock.virtualgarden.commands.AddPlantCommand;
import com.thelitblock.virtualgarden.commands.RemovePlantCommand;

import java.util.Arrays;

public class VirtualGarden {
    private static final Logger logger = LoggerFactory.getLogger(VirtualGarden.class);

    public static void main(String[] args) {
        logger.debug("Starting Virtual Garden application");
        try {
            Terminal terminal = TerminalBuilder.terminal();
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(new StringsCompleter("add", "remove", "display", "exit"))
                    .build();

            Garden garden = new Garden(2, 2);

            System.out.println("Welcome to Virtual Garden!");
            CommandRegistry commandRegistry = new CommandRegistry();
            commandRegistry.registerCommand(new AddPlantCommand(garden, lineReader));
            commandRegistry.registerCommand(new RemovePlantCommand(garden, lineReader));
            commandRegistry.registerCommand(new DisplayCommand(garden, lineReader));
            commandRegistry.registerCommand(new ExitCommand());

            while (true) {
                String input = lineReader.readLine("Enter command (add, remove, display, exit): ");
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