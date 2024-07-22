package com.thelitblock.virtualgarden.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thelitblock.virtualgarden.items.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, InventoryItem> items = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(Inventory.class);

    public Inventory() {
        initializeDefaultItems();
    }

    private void initializeDefaultItems() {
        for (ToolItem tool : ToolItemList.getDefaults()) {
            addItem(tool);
        }
    }

    public void addItem(InventoryItem item) {
        if (item instanceof Item castedItem) {
            if (castedItem.isStackable()) {
                if (items.containsKey(item.getId())) {
                    Item existingItem = (Item) items.get(item.getId());
                    existingItem.increaseQuantity(castedItem.getQuantity());
                } else {
                    items.put(item.getId(), item);
                }
            } else {
                String uniqueKey = item.getId() + "_" + System.nanoTime();
                items.put(uniqueKey, item);
            }
        }
        saveInventoryToFile();
    }

    private void saveInventoryToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(items);
        try (FileWriter writer = new FileWriter("src/main/resources/inventory.json")) {
            writer.write(json);
        } catch (IOException e) {
            logger.error("Failed to save inventory to file", e);
        }
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public InventoryItem getItem(String itemId) {
        return items.get(itemId);
    }

    public Map<String, InventoryItem> getAllItems() {
        return new HashMap<>(items);
    }
}