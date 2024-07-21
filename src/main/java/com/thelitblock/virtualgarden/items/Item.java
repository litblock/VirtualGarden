package com.thelitblock.virtualgarden.items;

import com.thelitblock.virtualgarden.items.InventoryItem;

public abstract class Item implements InventoryItem, Stackable {
    private String id;
    private String name;
    private String description;
    private ItemType itemType;
    private int quantity;
    private final boolean isStackable;

    public Item(ItemType itemType, String id, String name, String description, int quantity, boolean isStackable) {
        this.itemType = itemType;
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.isStackable = isStackable;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getQuantity() {
        if (isStackable) {
            return quantity;
        }
        else {
            return 1;
        }
    }

    @Override
    public void setQuantity(int quantity) {
        if (isStackable) {
            this.quantity = quantity;
        }
    }

    @Override
    public void increaseQuantity(int amount) {
        if (isStackable) {
            this.quantity += amount;
        }
    }

    @Override
    public void decreaseQuantity(int amount) {
        if (isStackable) {
            this.quantity = Math.max(0, this.quantity - amount);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean isStackable() {
        return isStackable;
    }
}