package com.thelitblock.virtualgarden;

import java.util.Scanner;

public class VirtualGarden {
    public static void main(String[] args) {
        Garden garden = new Garden();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Virtual Garden!");
        while (true) {
            System.out.println("Enter command (add, remove, display, exit):");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Enter plant type:");
                    String add = scanner.nextLine();
                    garden.addPlant(new Plant(add));
                    break;
                case "remove":
                    System.out.println("Enter plant type:");
                    String remove = scanner.nextLine();
                    garden.removePlant(remove);
                    break;
                case "display":
                    garden.displayGarden();
                    break;
                case "exit":
                    System.out.println("Exiting Virtual Garden.");
                    return;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}