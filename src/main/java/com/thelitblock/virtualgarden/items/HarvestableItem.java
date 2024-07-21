package com.thelitblock.virtualgarden.items;

public abstract class HarvestableItem extends Item {
    protected int quantity;
    protected HarvestableItemType harvestableItemType;

    public HarvestableItem(HarvestableItemType harvestableItemType, String id, String name, String description, int quantity, boolean isStackable) {
        super(ItemType.HARVESTABLEITEM, id, name, description, quantity, isStackable);
        this.quantity = quantity;
        this.harvestableItemType = harvestableItemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public HarvestableItemType getItemType() {
        return harvestableItemType;
    }

    public abstract void harvest();
}