package com.thelitblock.virtualgarden.items;

public class FruitItem extends HarvestableItem {
    private String type;

    public FruitItem(String id, String name, String description, int quantity, String type) {
        super(id, name, description, quantity);
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
        System.out.println("Harvesting " + quantity + " of " + name + " (" + type + ")");
        quantity--;
    }
}