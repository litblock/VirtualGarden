package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.items.*;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, InventoryItem> items = new HashMap<>();

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