package com.thelitblock.virtualgarden.items.tools;

import com.thelitblock.virtualgarden.items.Item;
import com.thelitblock.virtualgarden.items.ItemType;

public class ToolItem extends Item {
    private ToolType toolType;

    public ToolItem(String id, String name, String description, ToolType toolType, int quantity, boolean stackable) {
        super(ItemType.TOOLITEM, id, name, description, quantity, stackable);
        this.toolType = toolType;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    @Override
    public String toString() {
        return "ToolItem{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", toolType='" + toolType + '\'' +
                '}';
    }
}