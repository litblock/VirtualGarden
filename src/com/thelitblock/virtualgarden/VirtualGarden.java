package com.thelitblock.virtualgarden;

import java.util.Scanner;

public class VirtualGarden {
    public static void main(String[] args) {
        Garden garden = new Garden(5, 5); // Example size
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Virtual Garden!");
        while (true) {
            System.out.println("Enter command (add, remove, display, exit):");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Enter plant type, row, and column:");
                    String type = scanner.nextLine();
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    garden.addPlant(new Plant(type), row, col);
                    break;
                case "remove":
                    System.out.println("Enter plant type, row, and column to remove:");
                    type = scanner.nextLine();
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    scanner.nextLine();
                    garden.removePlant(type, row, col);
                    break;
                case "display":
                    garden.displayGarden();
                    break;
                case "exit":
                    System.out.println("Exiting Virtual Garden.");
                    return;
                default:
                    System.out.println("Unknown command. Try Again");
                    break;
            }
        }
    }
}