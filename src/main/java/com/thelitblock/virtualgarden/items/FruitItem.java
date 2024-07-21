package com.thelitblock.virtualgarden.items;

public class FruitItem extends HarvestableItem {
    private String type;
    //create fruit item enum
    public FruitItem(String id, String name, String description, int quantity, String type, boolean isStackable) {
        super(HarvestableItemType.FRUITITEM, id, name, description, quantity, isStackable);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting " + quantity + " of " + getName() + " (" + type + ")");
        quantity--;
    }
}