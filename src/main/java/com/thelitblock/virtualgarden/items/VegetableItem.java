package com.thelitblock.virtualgarden.items;

public class VegetableItem extends HarvestableItem {
    private String variety;

    public VegetableItem(String id, String name, String description, int quantity, String variety, boolean isStackable) {
        super(HarvestableItemType.VEGETABLEITEM, id, name, description, quantity, isStackable);
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
        System.out.println("Harvesting " + getQuantity() + " of " + getName() + " (" + variety + ")");
        setQuantity(getQuantity() - 1);
    }
}