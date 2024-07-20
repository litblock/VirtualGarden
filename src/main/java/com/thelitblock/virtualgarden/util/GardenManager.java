package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GardenManager {
    private List<Plant> plants = new ArrayList<>();
    private Garden garden;
    private Currency currency;
    private ScheduledExecutorService executorService;

    public GardenManager(Garden garden, int initialCurrency) {
        this.garden = garden;
        this.currency = new Currency(initialCurrency);
        this.executorService = Executors.newScheduledThreadPool(1);
        scheduleGrowthUpdates();
    }

    private void scheduleGrowthUpdates() {
        executorService.scheduleAtFixedRate(() -> {
            for (int row = 0; row < garden.getPlot().getRows(); row++) {
                for (int col = 0; col < garden.getPlot().getCols(); col++) {
                    Plant plant = garden.getPlot().getPlantAt(row, col);
                    if (plant != null) {
                        plant.updateGrowth(this);
                    }
                }
            }
        }, 0, 1, TimeUnit.MINUTES);
    }
    public void updateIndividualPlantGrowth(Plant plant) {
        GrowthStage nextStage = getNextGrowthStage(plant.getGrowthStage(), plant.getType());
        plant.setGrowthStage(nextStage);
    }

    public void updateGrowth() {
        for (int row = 0; row < garden.getPlot().getRows(); row++) {
            for (int col = 0; col < garden.getPlot().getCols(); col++) {
                Plant plant = garden.getPlot().getPlantAt(row, col);
                if (plant != null) {
                    GrowthStage nextStage = getNextGrowthStage(plant.getGrowthStage(), plant.getType());
                    plant.setGrowthStage(nextStage);
                }
            }
        }
    }

    private GrowthStage getNextGrowthStage(GrowthStage currentStage, PlantType plantType) {
        switch (plantType) {
            case FLOWER:
                switch (currentStage) {
                    case SEED:
                        return GrowthStage.SPROUT;
                    case SPROUT:
                        return GrowthStage.MATURE;
                    case MATURE:
                        return GrowthStage.FLOWERING;
                    case FLOWERING:
                        return GrowthStage.DEAD;
                    default:
                        return currentStage;
                }
            case TREE:
                switch (currentStage) {
                    case SEED:
                        return GrowthStage.SAPLING;
                    case SAPLING:
                        return GrowthStage.MATURE;
                    case MATURE:
                        return GrowthStage.FRUITING;
                    case FRUITING:
                        return GrowthStage.HARVESTED;
                    case HARVESTED:
                        return GrowthStage.MATURE; // Regrow after harvest
                    default:
                        return currentStage;
                }
            case VEGETABLE:
                switch (currentStage) {
                    case SEED:
                        return GrowthStage.SPROUT;
                    case SPROUT:
                        return GrowthStage.MATURE;
                    case MATURE:
                        return GrowthStage.VEGETATIVE;
                    case VEGETATIVE:
                        return GrowthStage.DEAD;
                    default:
                        return currentStage; // No further growth after DEAD
                }
            default:
                return currentStage;
        }
    }

    public void addPlantWithSubType(String subTypeInput, int row, int col) {
        Plant plant = null;
        String[] parts = subTypeInput.split(":");
        if (parts.length != 2) {
            System.out.println("Error: Invalid subtype input format.");
            return;
        }
        String plantTypeStr = parts[0].toUpperCase();
        String subTypeStr = parts[1].toUpperCase();

        try {
            PlantType plantType = PlantType.valueOf(plantTypeStr);
            switch (plantType) {
                case FLOWER:
                    FlowerType flowerType = FlowerType.valueOf(subTypeStr);
                    plant = new Flower(flowerType, "Flower Name");
                    break;
                case TREE:
                    TreeType treeType = TreeType.valueOf(subTypeStr);
                    plant = new Tree(treeType, 5);
                    break;
                case VEGETABLE:
                    VegetableType vegetableType = VegetableType.valueOf(subTypeStr);
                    plant = new Vegetable("Vegetable Name", vegetableType, 0);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid plant type or subtype.");
            return;
        }

        if (plant != null) {
            garden.addPlant(plant, row, col);
            System.out.println("Added " + plant.getClass().getSimpleName() + " to the garden at " + row + "," + col);
        }
    }

    public boolean isValidSubType(String subTypeInput, PlantType plantType) {
        try {
            switch (plantType) {
                case FLOWER:
                    FlowerType.valueOf(subTypeInput.toUpperCase());
                    break;
                case TREE:
                    TreeType.valueOf(subTypeInput.toUpperCase());
                    break;
                case VEGETABLE:
                    VegetableType.valueOf(subTypeInput.toUpperCase());
                    break;
                default:
                    return false;
            }
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean canAfford(int amount) {
        return currency.getBalance() >= amount;
    }

    public void spendCurrency(int amount) {
        currency.subtract(amount);
    }

    public void earnCurrency(int amount) {
        currency.add(amount);
    }

    public int getCurrencyBalance() {
        return currency.getBalance();
    }
}