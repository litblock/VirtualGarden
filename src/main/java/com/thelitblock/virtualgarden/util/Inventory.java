package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.items.InventoryItem;
import com.thelitblock.virtualgarden.items.Item;
import com.thelitblock.virtualgarden.items.ToolItem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, InventoryItem> items = new HashMap<>();

    public Inventory() {
        initializeDefaultItems();
    }

    private void initializeDefaultItems() {
        addItem(new ToolItem("1", "Watering Can", "A can for watering plants", "Watering", 1,  false));
        addItem(new ToolItem("2", "Hoe", "A tool for tilling soil", "Tilling", 1, false));
        addItem(new ToolItem("3", "Shovel", "A tool for digging holes", "Digging", 1, false));
        addItem(new ToolItem("4", "Fertilizer", "A bag of fertilizer", "Fertilizing", 5, true));
    }

    public void addItem(InventoryItem item) {
        if (item instanceof Item castedItem) {
            if (castedItem.isStackable()) {
                if (items.containsKey(item.getId())) {
                    Item existingItem = (Item) items.get(item.getId());
                    existingItem.increaseQuantity(castedItem.getQuantity());
                }
                else {
                    items.put(item.getId(), item);
                }
            }
            else {
                String uniqueKey = item.getId() + "_" + System.nanoTime();
                items.put(uniqueKey, item);
            }
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