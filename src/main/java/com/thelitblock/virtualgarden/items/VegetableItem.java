package com.thelitblock.virtualgarden.items;

public class VegetableItem extends HarvestableItem {
    private String variety;

    public VegetableItem(String id, String name, String description, int quantity, String variety) {
        super(id, name, description, quantity);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting " + quantity + " of " + name + " (" + variety + ")");
        quantity--;
    }
}