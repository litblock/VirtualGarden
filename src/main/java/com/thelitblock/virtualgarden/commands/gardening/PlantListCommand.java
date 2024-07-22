package com.thelitblock.virtualgarden.commands.gardening;

import com.thelitblock.virtualgarden.VegetableType;
import com.thelitblock.virtualgarden.commands.Command;

import java.util.Scanner;

public class PlantListCommand implements Command {

    @Override
    public String getName() {
        return "PlantList";
    }

    @Override
    public String getDescription() {
        return "Gets a list of plants that can be planted as well as stats";
    }

    @Override
    public void execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of plant you are interested in (e.g., 'vegetable'):");
        String plantTypeInput = scanner.nextLine().trim().toLowerCase();

        switch (plantTypeInput) {
            case "vegetable":
                displayVegetableTypes();
                break;
            case "flower":
                System.out.println("Flower plants are not yet supported.");
                break;
            case "tree":
                System.out.println("Fruit plants are not yet supported.");
                break;
            default:
                System.out.println("Unknown plant type.");
                break;
        }
    }

    private void displayVegetableTypes() {
        System.out.println("Available Vegetable Plants:");
        for (VegetableType plant : VegetableType.values()) {
            String plantInfo = String.format("%s - Cost: %d, Growth Factor: %.2f",
                    plant.name(), plant.getCost(), plant.getGrowthFactor());
            System.out.println(plantInfo);
        }
    }
}