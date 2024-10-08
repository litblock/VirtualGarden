package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.*;
import com.thelitblock.virtualgarden.items.HarvestableItem;
import com.thelitblock.virtualgarden.items.InventoryItem;
import com.thelitblock.virtualgarden.items.VegetableItem;
import com.thelitblock.virtualgarden.items.VegetableItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GardenManager {
    private List<Plant> plants = new ArrayList<>();
    private Garden garden;
    private Currency currency;
    private AlertManager alertManager = new AlertManager();
    private Inventory inventory = new Inventory();

    public GardenManager(Garden garden, int initialCurrency) {
        this.garden = garden;
        this.currency = new Currency(initialCurrency);
    }

    public static GrowthStage getNextGrowthStage(GrowthStage currentStage, PlantType plantType) {
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
                    case MATURE, VEGETATIVE:
                        return GrowthStage.VEGETATIVE;
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
                    //implement flower color
                    plant = new Flower(flowerType, "Flower Color", alertManager);
                    break;
                case TREE:
                    TreeType treeType = TreeType.valueOf(subTypeStr);
                    plant = new Tree(treeType, 5, alertManager);
                    break;
                case VEGETABLE:
                    VegetableType vegetableType = VegetableType.valueOf(subTypeStr);
                    plant = new Vegetable("Vegetable Name", vegetableType, alertManager);
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

    public Inventory getInventory() {
        return inventory;
    }

    public AlertManager getAlertManager() {
        return alertManager;
    }

    public Map<String, InventoryItem> getInventoryItems() {
        return inventory.getAllItems();
    }

    public Garden getGarden() {
        return garden;
    }

    public void harvestPlant(int row, int col) {
        Plant plant = garden.getPlot().getPlantAt(row, col);
        if (plant instanceof Vegetable) {
            Vegetable vegetable = (Vegetable) plant;
            if (vegetable.isHarvestable()) {
                VegetableItemType vegetableItemType = vegetable.getVegetableType().getItemType();
                if (vegetableItemType != null) {
                    Random random = new Random();
                    int quantity = 1 + random.nextInt(3);
                    InventoryItem item = new VegetableItem("6", vegetableItemType.name(), "vegetable", quantity, "vegetable", true);
                    inventory.addItem(item);
                    System.out.println("Harvested " + vegetableItemType.name() + " and added to inventory.");
                }
                vegetable.setGrowthStage(GrowthStage.DEAD);
                vegetable.setHarvestable(false);
                garden.getPlot().removePlant(row, col);
            } else {
                System.out.println("The plant at " + row + "," + col + " is not harvestable yet.");
            }
        } else {
            System.out.println("No harvestable plant found at the specified location.");
        }
    }
}