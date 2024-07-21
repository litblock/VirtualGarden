package com.thelitblock.virtualgarden.items;

public class ToolItem extends Item {
    private String toolType;

    public ToolItem(String id, String name, String description, String toolType) {
        super(id, name, description);
        this.toolType = toolType;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
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