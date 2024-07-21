package com.thelitblock.virtualgarden.util;

import com.thelitblock.virtualgarden.items.InventoryItem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, InventoryItem> items = new HashMap<>();

    public void addItem(InventoryItem item) {
        items.put(item.getId(), item);
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