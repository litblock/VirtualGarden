package com.thelitblock.virtualgarden.items;

public class DecorationItem extends Item {
    private String decorationType;

    public DecorationItem(String id, String name, String description, String decorationType, int quantity, boolean isStackable) {
        super(ItemType.DECORATIONITEM, id, name, description, quantity, isStackable);
        this.decorationType = decorationType;
    }

    public String getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType;
    }
}