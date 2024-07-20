package com.thelitblock.virtualgarden.items;

public abstract class HarvestableItem extends Item {
    protected int quantity;

    public HarvestableItem(String id, String name, String description, int quantity) {
        super(id, name, description);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void harvest();
}